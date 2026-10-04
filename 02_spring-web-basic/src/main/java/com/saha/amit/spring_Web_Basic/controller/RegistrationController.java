package com.saha.amit.spring_Web_Basic.controller;

import com.saha.amit.spring_Web_Basic.dto.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/users")
public class RegistrationController {

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
