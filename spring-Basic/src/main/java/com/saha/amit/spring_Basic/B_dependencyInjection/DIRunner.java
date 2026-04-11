package com.saha.amit.spring_Basic.B_dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * RUNNER: Comparison of Dependency Injection Types.
 */
@SpringBootApplication
public class DIRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DIRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("DI Type Demonstration");
        context.getBean(BusinessLogic.class).doWork();
        System.out.println("--------------------------------------------------");
    }

    @Service
    static class BusinessLogic {

        /* 
         * 1. CONSTRUCTOR INJECTION (Recommended)
         * Pros: 
         * - Allows fields to be 'final' (Immutability).
         * - Mandatory dependencies: Object cannot be created without providing this service.
         * - Easy to Unit Test: You can just call 'new BusinessLogic(mockService)'.
         */
        private final SimpleService simpleService;

        /* 
         * 2. FIELD INJECTION (Why it is BAD)
         * Cons:
         * - Hidden Dependencies: You can't see what this class needs just by looking at the constructor.
         * - Hard to Unit Test: You cannot instantiate this class in a plain JUnit test 
         *   without using Reflection or starting a full Spring Context.
         * - Tight Coupling: The class is strictly dependent on a DI container.
         */
        @Autowired
        private SimpleService2 simpleService2;

        private SimpleService3 simpleService3;

        /* 
         * 3. SETTER INJECTION (When to use)
         * Use Case:
         * - Optional Dependencies: If the class can function even without this service.
         * - Circular Dependencies: Can sometimes resolve cycles that constructors can't.
         */
        @Autowired
        public void setSimpleService3(SimpleService3 simpleService3){
            System.out.println("Setter Injection happening for SimpleService3...");
            this.simpleService3 = simpleService3;
        }

        public BusinessLogic(SimpleService simpleService) {
            System.out.println("Constructor Injection happening for SimpleService...");
            this.simpleService = simpleService;
        }

        public void doWork() {
            System.out.println("Output 1: " + simpleService.getMessage());
            System.out.println("Output 2: " + simpleService2.getMessage());
            System.out.println("Output 3: " + simpleService3.getMessage());
        }
    }

    @Component
    static class SimpleService {
        public String getMessage() { return "Mandatory Service (Constructor)"; }
    }

    @Component
    static class SimpleService2 {
        public String getMessage() { return "Hidden Service (Field)"; }
    }

    @Component
    static class SimpleService3 {
        public String getMessage() { return "Optional Service (Setter)"; }
    }
}
