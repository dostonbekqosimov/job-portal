package com.doston.JobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.doston.JobApp.service.JobService.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        LOGGER.info("Method is calling: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.doston.JobApp.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint) {
        LOGGER.info("Method executed: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.doston.JobApp.service.JobService.*(..))")
    public void logMethodHasError(JoinPoint joinPoint) {
        LOGGER.info("Method has problem: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.doston.JobApp.service.JobService.*(..))")
    public void logMethodExecutedWithSuccess(JoinPoint joinPoint) {
        LOGGER.info("Method executed successfully: " + joinPoint.getSignature().getName());
    }
}
