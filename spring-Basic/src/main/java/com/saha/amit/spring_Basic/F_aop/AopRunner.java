package com.saha.amit.spring_Basic.F_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * RUNNER: AOP (Aspect Oriented Programming) demonstration.
 */
@SpringBootApplication
public class AopRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("AOP Demo (Look for [AOP] in logs before method call)");
        BusinessService service = context.getBean(BusinessService.class);
        service.doWork();
        System.out.println("--------------------------------------------------");
    }

    /**
     * BUSINESS SERVICE: A regular Spring Service.
     */
    @Service
    static class BusinessService {
        public void doWork() {
            System.out.println("Business: Service is performing actual work...");
        }
    }

    /**
     * ASPECT: Best Practice: Use for cross-cutting concerns like logging,
     * security, or performance tracking to keep business logic clean.
     */
    @Aspect
    @Component
    static class LoggingAspect {

        // Pointcut: All methods in 'F_aop' package
        @Before("execution(* com.saha.amit.spring_Basic.F_aop.*.*(..))")
        public void logBefore() {
            System.out.println("[AOP] Log: Intercepting call before business method...");
        }
    }
}
