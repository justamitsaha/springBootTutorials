package com.saha.amit.spring_Basic.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * RUNNER: Bean Scopes, Lifecycle Hooks, and Lazy Loading.
 */
@SpringBootApplication
public class LifecycleRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LifecycleRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("1. Bean Scopes (Singleton vs Prototype)");
        System.out.println("Singleton Bean 1: " + context.getBean("singletonBean"));
        System.out.println("Singleton Bean 2: " + context.getBean("singletonBean"));

        System.out.println("Prototype Bean 1: " + context.getBean("prototypeBean"));
        System.out.println("Prototype Bean 2: " + context.getBean("prototypeBean"));

        System.out.println("--------------------------------------------------");
        System.out.println("2. Lazy Loading (@Lazy)");
        System.out.println("Lazy bean hasn't been created yet. Requesting it now...");
        Object lazyBean = context.getBean("lazyBean");
        System.out.println("Lazy Bean is now: " + lazyBean);

        System.out.println("--------------------------------------------------");
        System.out.println("3. Lifecycle Hooks (Look at PostConstruct in logs)");
        System.out.println("--------------------------------------------------");
    }
}
