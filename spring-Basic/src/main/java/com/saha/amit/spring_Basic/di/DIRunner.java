package com.saha.amit.spring_Basic.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * RUNNER: Dependency Injection & Resolution.
 */
@SpringBootApplication
public class DIRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DIRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("1. Constructor Injection (BusinessLogic)");
        context.getBean(BusinessLogic.class).doWork();

        System.out.println("--------------------------------------------------");
        System.out.println("2. Resolution Strategy (@Primary vs @Qualifier)");
        System.out.println("Default (@Primary):");
        context.getBean(SearchService.class).executeSearch();
        
        System.out.println("Specific (@Qualifier):");
        context.getBean(HighPrioritySearchService.class).executeSearch();
        System.out.println("--------------------------------------------------");
    }
}
