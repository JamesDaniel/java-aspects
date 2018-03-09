package com.in28minutes.springboot.tutorial.basics.example.springboottutorialbasics.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// Aspect is a combination of the Pointcut and Advice
@Aspect
@Configuration
public class UserAccessAspect {

    private Logger logger = LoggerFactory.getLogger(UserAccessAspect.class);

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    // The Pointcut is execution(* com.in28minutes.springboot.tutorial.basics.example.springboottutorialbasics.data.*.*(..)),
    // which defines when a call to a method should be intercepted.
    @Before("com.in28minutes.springboot.tutorial.basics.example.springboottutorialbasics.aspects.CommonJoinPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint){
        // The JoinPoint is a specific execution instance of an Advice. When code is executed and Pointcut  is met, the
        // Advice is executed.
        // Advice is the code you want to invoke when intercepting a method.
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
    }

}
