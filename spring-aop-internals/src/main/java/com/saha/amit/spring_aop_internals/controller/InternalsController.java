package com.saha.amit.spring_aop_internals.controller;

import com.saha.amit.spring_aop_internals.service.BusinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/internals")
public class InternalsController {

    private final BusinessService businessService;

    public InternalsController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/aop")
    public String testAop() throws InterruptedException {
        return businessService.slowMethod();
    }

    @GetMapping("/async")
    public CompletableFuture<String> testAsync() throws InterruptedException {
        System.out.println("[Controller] Calling async method from thread: " + Thread.currentThread().getName());
        return businessService.asyncMethod();
    }
}
