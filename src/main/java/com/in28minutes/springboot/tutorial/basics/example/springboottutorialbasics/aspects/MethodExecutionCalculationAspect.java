package com.in28minutes.springboot.tutorial.basics.example.springboottutorialbasics.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(MethodExecutionCalculationAspect.class);

    @Around("@annotation(com.in28minutes.springboot.tutorial.basics.example.springboottutorialbasics.aspects.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;

        long startTime = System.currentTimeMillis();

        result = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);

        logger.info("Class name: " + joinPoint.getSignature().getDeclaringTypeName());
        logger.info("Method name: " + joinPoint.getSignature().getName());
        logger.info("Args length: " + joinPoint.getArgs().length);
        for (Object obj: joinPoint.getArgs()) {
            logger.info("Args: " + obj.toString());
        }
        Signature signature =  joinPoint.getSignature();
        Class returnType = ((MethodSignature) signature).getReturnType();
        logger.info("Return type: " + returnType.getName());

        return result;
    }
}
