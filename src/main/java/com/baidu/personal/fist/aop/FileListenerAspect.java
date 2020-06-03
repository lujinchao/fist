package com.baidu.personal.fist.aop;

import com.baidu.personal.fist.config.ClientConfig;
import com.baidu.personal.fist.config.IgnoreConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-16 10:44:52
 */

@Aspect
@Component
@Slf4j
public class FileListenerAspect {

    static final String FILE = "file";

    static final String DIR = "directory";

    @Autowired
    private ClientConfig clientConfig;

    @Autowired
    private IgnoreConfig ignoreConfig;

    @Around("execution(public * com.baidu.personal.fist.client.FileListener.onFile*(..)) || execution(" +
            "public * com.baidu.personal.fist.client.FileListener.onDirectory*(..))")
    public void invokeAround(ProceedingJoinPoint pjp) throws Throwable {
        File file = (File) pjp.getArgs()[0];
        String type = file.isDirectory() ? DIR : FILE;
        String relativePath = StringUtils.removeStart(file.getAbsolutePath(), clientConfig.getRoot());
        if (!ignoreConfig.ignore(relativePath)) {
            long startTime = System.currentTimeMillis();
            pjp.proceed();
            long endTime = System.currentTimeMillis();
            log.info("sync completed, time cost: {} ms", endTime - startTime);
        }
        else {
            log.info("{} ignored: {}", type, file.getAbsolutePath());
        }
    }
}
