package com.saha.amit.spring_Basic.F_aop;

import org.springframework.stereotype.Service;

/**
 * BUSINESS SERVICE: A regular Spring Service.
 */
@Service
public class BusinessService {
    public void doWork() {
        System.out.println("Business: Service is performing actual work...");
    }
}