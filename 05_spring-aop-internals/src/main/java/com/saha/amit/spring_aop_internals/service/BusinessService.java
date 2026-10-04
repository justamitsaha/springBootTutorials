package com.saha.amit.spring_aop_internals.service;

import com.saha.amit.spring_aop_internals.annotation.LogExecutionTime;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class BusinessService {

    @LogExecutionTime
    public String slowMethod() throws InterruptedException {
        Thread.sleep(1000);
        return "Slow method finished";
    }

    @Async
    public CompletableFuture<String> asyncMethod() throws InterruptedException {
        System.out.println("[Async] Executing in thread: " + Thread.currentThread().getName());
        Thread.sleep(2000);
        return CompletableFuture.completedFuture("Async work done");
    }
}
