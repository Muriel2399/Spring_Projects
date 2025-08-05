package com.telusko.SpringBootRest.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.telusko.SpringBootRest.service.JobService.getJob(..)) && args(postId) ")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {

        if(postId <0)
        {
            LOGGER.info("Post id is negative ,updating it "+postId);
            postId = -postId;
            LOGGER.info("Updated post id is "+postId);
        }


        Object obj =jp.proceed(new Object[]{postId});

        return obj;
    }
}
