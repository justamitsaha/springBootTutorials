package com.saha.amit.spring_Basic.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class SimpleService {
    public String getMessage() {
        return "Hello from SimpleService!";
    }
}
