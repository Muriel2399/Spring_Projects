package com.telusko.SpringBootRest.app;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    //return type, class-name.method-name, args
    @Before("execution(* com.telusko.SpringBootRest.service.JobService.getJob(..)) || execution(* com.telusko.SpringBootRest.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp) {
     LOGGER.info("Log method called "+jp.getSignature().getName());
    }

    @After("execution(* com.telusko.SpringBootRest.service.JobService.getJob(..)) || execution(* com.telusko.SpringBootRest.service.JobService.getAllJobs(..))")
    public void LogMthodExecuted(JoinPoint jp) {
        LOGGER.info("Log method executed "+jp.getSignature().getName());
    }


    @AfterThrowing("execution(* com.telusko.SpringBootRest.service.JobService.getJob(..)) || execution(* com.telusko.SpringBootRest.service.JobService.getAllJobs(..))")
    public void LogMthodCrash(JoinPoint jp) {
        LOGGER.info("Log method issues "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.telusko.SpringBootRest.service.JobService.getJob(..)) || execution(* com.telusko.SpringBootRest.service.JobService.getAllJobs(..))")
    public void LogMthodSuccess(JoinPoint jp) {
        LOGGER.info("Log method success "+jp.getSignature().getName());
    }




}


