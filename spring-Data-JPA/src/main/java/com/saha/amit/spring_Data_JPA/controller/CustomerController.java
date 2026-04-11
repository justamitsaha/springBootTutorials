package com.saha.amit.spring_Data_JPA.controller;

import com.saha.amit.spring_Data_JPA.entity.Customer;
import com.saha.amit.spring_Data_JPA.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        if (customer.getOrders() != null) {
            customer.getOrders().forEach(order -> order.setCustomer(customer));
        }
        return customerRepository.save(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
