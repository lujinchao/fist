package com.baidu.personal.fist.client;

import com.baidu.personal.fist.config.ClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-11 10:27:44
 *
 * 客户端入口类
 */

@Slf4j
@Component
public class ClientMain {

    @Autowired
    private ClientConfig clientConfig;

    @Autowired
    private FileListener fileListener;

    public void run(boolean initialize) throws Exception {
        log.info("client root is: {}", clientConfig.getRoot());
        long interval = TimeUnit.SECONDS.toMillis(1);
        FileAlterationObserver observer = new FileAlterationObserver(new File(clientConfig.getRoot()));
        fileListener.prepare();
        // 判断是否需要初始化
        if (initialize) {
            fileListener.initialize();
        }
        // 添加listener至observer，启动observer
        observer.addListener(fileListener);
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        monitor.start();
    }
}
