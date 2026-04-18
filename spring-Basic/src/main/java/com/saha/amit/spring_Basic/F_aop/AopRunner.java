package com.saha.amit.spring_Basic.F_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * RUNNER: AOP (Aspect Oriented Programming) demonstration.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class AopRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("AOP Demo (Look for [AOP] in logs before method call)");
        BusinessService service = context.getBean(BusinessService.class);
        service.doWork();
        System.out.println("--------------------------------------------------");
    }
}
