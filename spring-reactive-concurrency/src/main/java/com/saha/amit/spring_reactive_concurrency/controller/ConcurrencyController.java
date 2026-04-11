package com.saha.amit.spring_reactive_concurrency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/threads")
public class ConcurrencyController {

    /**
     * VIRTUAL THREADS (Project Loom):
     * Best Practice: Use for high-concurrency I/O bound tasks.
     */
    @GetMapping("/info")
    public String getThreadInfo() {
        Thread thread = Thread.currentThread();
        String isVirtual = thread.isVirtual() ? "Virtual Thread" : "Platform Thread";
        return "Executing on: " + thread.getName() + " (" + isVirtual + ")";
    }
}
