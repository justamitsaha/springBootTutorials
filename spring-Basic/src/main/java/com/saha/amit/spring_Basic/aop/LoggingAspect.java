package com.saha.amit.spring_Basic.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * BASIC AOP: Intercepting method execution without changing the code.
 */
@Aspect
@Component
public class LoggingAspect {

    // Pointcut: All methods in 'dependencyInjection' package
    @Before("execution(* com.saha.amit.spring_Basic.dependencyInjection.*.*(..))")
    public void logBefore() {
        System.out.println("[AOP] Log: Executing a business method in 'dependencyInjection' package...");
    }
}
