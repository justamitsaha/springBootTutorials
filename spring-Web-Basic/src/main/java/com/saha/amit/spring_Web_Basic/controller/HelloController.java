package com.saha.amit.spring_Web_Basic.controller;

import com.saha.amit.spring_Web_Basic.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot Web!";
    }

    @GetMapping("/users/{name}")
    public UserDto getUser(@PathVariable String name) {
        return new UserDto(name, name.toLowerCase() + "@example.com");
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "default") String query) {
        return "Search result for: " + query;
    }
}
