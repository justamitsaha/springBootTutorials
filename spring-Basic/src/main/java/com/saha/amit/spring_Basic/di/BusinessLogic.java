package com.saha.amit.spring_Basic.di;

import org.springframework.stereotype.Service;

/**
 * CONSTRUCTOR INJECTION: Preferred method for dependencies.
 * Spring will automatically inject SimpleService.
 */
@Service
public class BusinessLogic {
    private final SimpleService simpleService;

    public BusinessLogic(SimpleService simpleService) {
        System.out.println("Constructor Injection happening...");
        this.simpleService = simpleService;
    }

    public void doWork() {
        System.out.println(simpleService.getMessage());
    }
}
