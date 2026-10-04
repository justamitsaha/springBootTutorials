package com.saha.amit.spring_Data_JPA.controller;

import com.saha.amit.spring_Data_JPA.entity.Customer;
import com.saha.amit.spring_Data_JPA.projection.CustomerSummary;
import com.saha.amit.spring_Data_JPA.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/performance")
public class PerformanceController {

    private final CustomerRepository customerRepository;

    public PerformanceController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/n-plus-one")
    public List<Customer> getNPlusOneData() {
        return customerRepository.findAll();
    }

    @GetMapping("/join-fetch")
    public List<Customer> getJoinFetchData() {
        return customerRepository.findAllWithOrders();
    }

    @GetMapping("/projections")
    public List<CustomerSummary> getProjections() {
        return customerRepository.findAllProjectedBy();
    }
}
