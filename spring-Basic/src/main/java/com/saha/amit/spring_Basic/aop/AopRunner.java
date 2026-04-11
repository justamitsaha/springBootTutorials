package com.saha.amit.spring_Basic.aop;

import com.saha.amit.spring_Basic.di.BusinessLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * RUNNER: AOP (Aspect Oriented Programming) demonstration.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.saha.amit.spring_Basic.di", "com.saha.amit.spring_Basic.aop"})
public class AopRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("AOP Demo (Look for [AOP] in logs before method call)");
        // BusinessLogic is in the 'di' package, so AOP will intercept its methods.
        context.getBean(BusinessLogic.class).doWork();
        System.out.println("--------------------------------------------------");
    }
}
