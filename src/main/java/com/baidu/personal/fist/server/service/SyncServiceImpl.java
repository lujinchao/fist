package com.baidu.personal.fist.server.service;

import com.baidu.personal.fist.config.ServerConfig;
import com.baidu.personal.fist.grpc.SyncMsg;
import com.baidu.personal.fist.grpc.SyncMsg.SyncRequest;
import com.baidu.personal.fist.grpc.SyncMsg.SyncResponse;
import com.baidu.personal.fist.grpc.SyncServiceGrpc;
import com.baidu.personal.fist.utils.ByteUtil;
import com.baidu.personal.fist.utils.FileUtil;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-11 17:23:58
 */

@Slf4j
@Component
public class SyncServiceImpl extends SyncServiceGrpc.SyncServiceImplBase {

    @Autowired
    private ServerConfig serverConfig;

    @Override
    public void processFileCreate(SyncMsg.SyncRequest request,
                                  StreamObserver<SyncMsg.SyncResponse> responseObserver) {
        String relativePath = ByteUtil.getString(request.getFilePath());
        // 得到server端的文件绝对路径，覆写内容
        String absolutePath = serverConfig.getRoot() + relativePath;
        log.info("receive file create request: {}", absolutePath);
        FileUtil.overwriteFile(absolutePath, request.getFileContent());
        // 构造返回成功的返回请求
        sendResponse(responseObserver, SyncMsg.SyncResponse.Result.ResultCode.SUCCESS, ByteString.EMPTY);
    }

    @Override
    public void processFileModify(SyncMsg.SyncRequest request,
                                  StreamObserver<SyncMsg.SyncResponse> responseObserver) {
        String relativePath = ByteUtil.getString(request.getFilePath());
        // 得到server端的文件绝对路径，覆写内容
        String absolutePath = serverConfig.getRoot() + relativePath;
        log.info("receive file modify request: {}", absolutePath);
        FileUtil.overwriteFile(absolutePath, request.getFileContent());
        // 构造返回成功的返回请求
        sendResponse(responseObserver, SyncResponse.Result.ResultCode.SUCCESS, ByteString.EMPTY);
    }

    @Override
    public void processFileDelete(SyncRequest request,
                                  StreamObserver<SyncResponse> responseObserver) {
        String relativePath = ByteUtil.getString(request.getFilePath());
        // 得到server端的文件绝对路径，删除文件
        String absolutePath = serverConfig.getRoot() + relativePath;
        log.info("receive file delete request: {}", absolutePath);
        FileUtil.deleteFile(absolutePath);
        // 构造返回成功的返回请求
        sendResponse(responseObserver, SyncResponse.Result.ResultCode.SUCCESS, ByteString.EMPTY);
    }

    @Override
    public void processDirectoryCreate(SyncRequest request,
                                       StreamObserver<SyncResponse> responseObserver) {
        String relativePath = ByteUtil.getString(request.getFilePath());
        // 得到server端的文件夹绝对路径，创建文件夹
        String absolutePath = serverConfig.getRoot() + relativePath;
        log.info("receive directory create request: {}", absolutePath);
        FileUtil.createDirectory(absolutePath);
        // 构造返回请求
        sendResponse(responseObserver, SyncResponse.Result.ResultCode.SUCCESS, ByteString.EMPTY);
    }

    @Override
    public void processDirectoryDelete(SyncRequest request,
                                       StreamObserver<SyncResponse> responseObserver) {
        String relativePath = ByteUtil.getString(request.getFilePath());
        // 得到server端的文件绝对路径，删除文件
        String absolutePath = serverConfig.getRoot() + relativePath;
        log.info("receive directory delete request: {}", absolutePath);
        FileUtil.deleteFile(absolutePath);
        // 构造返回成功的返回请求
        sendResponse(responseObserver, SyncResponse.Result.ResultCode.SUCCESS, ByteString.EMPTY);
    }

    private void sendResponse(StreamObserver<SyncResponse> responseObserver,
                              SyncResponse.Result.ResultCode resultCode, ByteString errMsg) {
        SyncResponse.Builder responseBuilder = SyncResponse.newBuilder();
        SyncResponse.Result.Builder resultBuilder = SyncResponse.Result.newBuilder();
        resultBuilder.setResCode(resultCode);
        resultBuilder.setErrMsg(errMsg);
        responseBuilder.setResult(resultBuilder.build());
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
