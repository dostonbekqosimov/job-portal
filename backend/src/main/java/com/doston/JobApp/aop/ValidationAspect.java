package com.doston.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.doston.JobApp.service.JobService.getJobById(..)) && args(id)")
    public Object validateAndUpdate(ProceedingJoinPoint joinPoint, int id) throws Throwable {
        if (id < 0) {
            LOGGER.info("PostId is negative, updating it");
            id = -id;
            LOGGER.info("new value " + id);
        }

        return joinPoint.proceed(new Object[]{id});
    }

}
