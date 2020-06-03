package com.baidu.personal.fist.server;

import com.baidu.personal.fist.config.ServerConfig;
import com.baidu.personal.fist.config.TokenInterceptor;
import com.baidu.personal.fist.grpc.AuthServiceGrpc;
import com.baidu.personal.fist.grpc.SyncServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-11 17:23:32
 */

@Slf4j
@Component
public class ServerMain {

    private Server server;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private SyncServiceGrpc.SyncServiceImplBase syncServiceImplBase;

    @Autowired
    private AuthServiceGrpc.AuthServiceImplBase authServiceImplBase;

    @Autowired
    private TokenInterceptor tokenInterceptor;

    /**
     * 开启服务
     * @throws IOException
     */
    public void start() throws Exception {
        server = ServerBuilder.forPort(serverConfig.getPort())
                .addService(syncServiceImplBase)
                .addService(authServiceImplBase)
                .intercept(tokenInterceptor)
                .build()
                .start();
        log.info("start fist server at port：{}", serverConfig.getPort());
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    log.warn("because jvm was stopped, close grpc service now...");
                    this.stop();
                    log.info("grpc service has been closed...");
                }));
    }

    /**
     * 关闭服务
     */
    public void stop() {
        Optional.of(server).map(s -> s.shutdown()).orElse(null);
    }

    /**
     * 循环运行服务，封锁停止
     * @throws InterruptedException
     */
    public void blockUnitShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public void run() throws Exception {
        log.info("server root directory is：{}", serverConfig.getRoot());
        this.start();
        this.blockUnitShutdown();
    }
}
