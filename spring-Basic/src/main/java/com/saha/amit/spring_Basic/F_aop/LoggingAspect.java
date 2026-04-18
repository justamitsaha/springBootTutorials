package com.saha.amit.spring_Basic.F_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * ASPECT: Best Practice: Use for cross-cutting concerns like logging,
 * security, or performance tracking to keep business logic clean.
 */
@Aspect
@Component
public class LoggingAspect {

    // Pointcut: All methods in 'F_aop' package
    @Before("execution(* com.saha.amit.spring_Basic.F_aop.*.*(..))")
    public void logBefore() {
        System.out.println("[AOP] Log: Intercepting call before business method...");
    }
}