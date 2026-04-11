package com.saha.amit.spring_Basic.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    }

    /**
     * CONSTRUCTOR INJECTION: Preferred method for dependencies.
     * Spring will automatically inject SimpleService.
     */
    @Service
    static class BusinessLogic {

        private final SimpleService simpleService;

        @Autowired
        private SimpleService2 simpleService2;

        private SimpleService3 simpleService3;

        @Autowired
        public void setSimpleService3(SimpleService3 simpleService3){
            this.simpleService3= simpleService3;
        }

        public BusinessLogic(SimpleService simpleService) {
            System.out.println("Constructor Injection happening...");
            this.simpleService = simpleService;
        }

        public void doWork() {
            System.out.println(simpleService.getMessage());
            System.out.println(simpleService2.getMessage());
            System.out.println(simpleService3.getMessage());

        }
    }

    @Component
    static class SimpleService {
        public String getMessage() {
            return "Hello from SimpleService!";
        }
    }

    @Component
    static class SimpleService2{
        public String getMessage() {
            return "Hello from SimpleService2!";
        }
    }

    @Component
    static class SimpleService3{
        public String getMessage() {
            return "Hello from SimpleService3!";
        }
    }
}
