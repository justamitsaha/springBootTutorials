package com.saha.amit.spring_observability_resilience.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ResilientService {

    /**
     * CIRCUIT BREAKER: Best Practice: Protect your app from cascading failures 
     * when a downstream service is down.
     */
    @CircuitBreaker(name = "externalService", fallbackMethod = "fallbackResponse")
    public String callSlowExternalService() {
        System.out.println("[Resilience] Attempting to call external service...");
        if (new Random().nextInt(10) > 2) { // 70% failure rate for demo
            throw new RuntimeException("External Service is DOWN!");
        }
        return "Success from External Service!";
    }

    /**
     * RETRY: Automatically retry a failed operation.
     */
    @Retry(name = "dbRetry", fallbackMethod = "fallbackResponse")
    public String callUnstableDb() {
        System.out.println("[Resilience] Attempting DB call...");
        throw new RuntimeException("Database timeout!");
    }

    public String fallbackResponse(Throwable t) {
        return "Fallback: Service is currently unavailable. Error: " + t.getMessage();
    }
}
