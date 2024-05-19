package com.doston.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.doston.JobApp.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startingTime = System.currentTimeMillis();


        Object object = joinPoint.proceed();


        long endingTime = System.currentTimeMillis();

        LOGGER.info("Time taken by: " + joinPoint.getSignature().getName() + " : " + (endingTime - startingTime) + " ms");
        return object;
    }

}
