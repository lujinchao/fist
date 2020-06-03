package com.baidu.personal.fist.client;

import com.baidu.personal.fist.config.ClientConfig;
import com.baidu.personal.fist.config.IgnoreConfig;
import com.baidu.personal.fist.config.ServerConfig;
import com.baidu.personal.fist.grpc.AuthMsg;
import com.baidu.personal.fist.grpc.AuthServiceGrpc;
import com.baidu.personal.fist.grpc.SyncMsg;
import com.baidu.personal.fist.grpc.SyncServiceGrpc;
import com.baidu.personal.fist.utils.ByteUtil;
import io.grpc.*;
import io.grpc.stub.MetadataUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-11 10:09:23
 */

@Slf4j
@Component
public class FileListener extends FileAlterationListenerAdaptor {

    @Autowired
    private ClientConfig clientConfig;

    @Autowired
    private IgnoreConfig ignoreConfig;

    @Autowired
    private ServerConfig serverConfig;

    private SyncServiceGrpc.SyncServiceBlockingStub blockingStub;

    private String token;

    @Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
    }

    @Override
    public void onDirectoryCreate(File directory) {
        String relativePath = StringUtils.removeStart(directory.getAbsolutePath(), clientConfig.getRoot());
        log.info("directory created: {}", directory.getAbsolutePath());
        SyncMsg.SyncRequest.Builder requestBuilder = getSyncRequestBuilder(relativePath);
        blockingStub.processDirectoryCreate(requestBuilder.build());
    }

    @Override
    public void onDirectoryDelete(File directory) {
        String relativePath = StringUtils.removeStart(directory.getAbsolutePath(), clientConfig.getRoot());
        log.info("directory deleted: {}", directory.getAbsolutePath());
        SyncMsg.SyncRequest.Builder requestBuilder = getSyncRequestBuilder(relativePath);
        blockingStub.processDirectoryDelete(requestBuilder.build());
    }

    @Override
    public void onFileCreate(File file) {
        String relativePath = StringUtils.removeStart(file.getAbsolutePath(), clientConfig.getRoot());
        log.info("file created: {}", file.getAbsolutePath());
        SyncMsg.SyncRequest.Builder requestBuilder = getSyncRequestBuilder(relativePath);
        requestBuilder.setFileContent(ByteUtil.getByteString(new String(ByteUtil.getBytesFromFile(file))));
        blockingStub.processFileCreate(requestBuilder.build());
    }

    @Override
    public void onFileChange(File file) {
        String relativePath = StringUtils.removeStart(file.getAbsolutePath(), clientConfig.getRoot());
        log.info("file changed: {}", file.getAbsolutePath());
        SyncMsg.SyncRequest.Builder requestBuilder = getSyncRequestBuilder(relativePath);
        requestBuilder.setFileContent(ByteUtil.getByteString(new String(ByteUtil.getBytesFromFile(file))));
        blockingStub.processFileModify(requestBuilder.build());
    }

    @Override
    public void onFileDelete(File file) {
        String relativePath = StringUtils.removeStart(file.getAbsolutePath(), clientConfig.getRoot());
        log.info("file deleted: {}", file.getAbsolutePath());
        SyncMsg.SyncRequest.Builder requestBuilder = getSyncRequestBuilder(relativePath);
        blockingStub.processFileDelete(requestBuilder.build());
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
    }

    private SyncMsg.SyncRequest.Builder getSyncRequestBuilder(String relativePath) {
        SyncMsg.SyncRequest.Builder requestBuilder = SyncMsg.SyncRequest.newBuilder();
        requestBuilder.setFilePath(ByteUtil.getByteString(relativePath));
        return requestBuilder;
    }

    public void prepare() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress(this.serverConfig.getHost(), this.serverConfig.getPort())
                .usePlaintext()
                .intercept(new ClientInterceptor() {
                    @Override
                    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                            MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
                        Metadata metadata = new Metadata();
                        if (token != null) {
                            metadata.put(Metadata.Key.of("token", Metadata.ASCII_STRING_MARSHALLER), token);
                        }
                        return MetadataUtils.newAttachHeadersInterceptor(metadata)
                                .interceptCall(methodDescriptor, callOptions, channel);
                    }
                })
                .build();
        try {
            AuthServiceGrpc.AuthServiceBlockingStub authService = AuthServiceGrpc.newBlockingStub(managedChannel);
            AuthMsg.Result result =
                    authService.authenticate(AuthMsg.Credit.newBuilder()
                            .setUsername(this.clientConfig.getUsername())
                            .setPassword(this.clientConfig.getPassword())
                            .build());
            if (result.getSuccess()) {
                this.token = result.getToken();
                blockingStub = SyncServiceGrpc.newBlockingStub(managedChannel);
            }
            else {
                log.error("auth failed, please check username or password");
                System.exit(1);
            }
        } catch (Exception exception) {
            log.error("connect to server failed, please check whether server has been started");
        }
    }

    public void initialize() {
        log.info("start to initialize, make server same as client");
        String root = this.clientConfig.getRoot();
        walkDir(new File(root));
        log.info("initialize completed");
    }

    private void walkDir(File file) {
        String relativePath = StringUtils.removeStart(file.getAbsolutePath(), clientConfig.getRoot());
        boolean ignore = ignoreConfig.ignore(relativePath);
        if (file.isDirectory()) {
            if (!ignore) {
                log.info("initialize directory: {}", file.getAbsolutePath());
                SyncMsg.SyncRequest.Builder requestBuilder = getSyncRequestBuilder(relativePath);
                blockingStub.processDirectoryCreate(requestBuilder.build());
                log.info("done");
                File[] fileList = file.listFiles();
                for (File f : fileList) {
                    walkDir(f);
                }
            }
            else {
                log.info("directory ignored: {}", file.getAbsolutePath());
            }
        }
        else {
            if (!ignore) {
                log.info("initialize directory: {}", file.getAbsolutePath());
                SyncMsg.SyncRequest.Builder requestBuilder = getSyncRequestBuilder(relativePath);
                requestBuilder.setFileContent(ByteUtil.getByteString(new String(ByteUtil.getBytesFromFile(file))));
                blockingStub.processFileCreate(requestBuilder.build());
                log.info("done");
            }
            else {
                log.info("file ignored: {}", file.getAbsolutePath());
            }
        }
    }
}
