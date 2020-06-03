package com.baidu.personal.fist.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-16 10:44:52
 */

@Aspect
@Component
@Slf4j
public class SyncServiceAspect {

    @Around("execution(public * com.baidu.personal.fist.server.service.SyncServiceImpl.process*(..))")
    public void invokeAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("sync completed, time cost: {} ms", endTime - startTime);
    }
}
