package com.telusko.SpringBootRest.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.telusko.SpringBootRest.service.JobService.getJob(..)) ")
    public Object MonitorTime(ProceedingJoinPoint jp) throws Throwable {
       long start= System.currentTimeMillis();
       Object obj =jp.proceed();
        long end =System.currentTimeMillis();
        LOGGER.info("Total time taken "+(end-start)+" ms");
        return obj;
    }


}
