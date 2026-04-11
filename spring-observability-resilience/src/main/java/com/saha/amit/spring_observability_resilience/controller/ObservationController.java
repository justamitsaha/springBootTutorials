package com.saha.amit.spring_observability_resilience.controller;

import com.saha.amit.spring_observability_resilience.service.ResilientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obs")
public class ObservationController {

    private final ResilientService resilientService;

    public ObservationController(ResilientService resilientService) {
        this.resilientService = resilientService;
    }

    @GetMapping("/circuit-breaker")
    public String testCircuitBreaker() {
        return resilientService.callSlowExternalService();
    }

    @GetMapping("/retry")
    public String testRetry() {
        return resilientService.callUnstableDb();
    }
}
