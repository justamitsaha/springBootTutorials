package com.saha.amit.spring_Basic.di;

import org.springframework.stereotype.Component;

@Component
public class SimpleService {
    public String getMessage() {
        return "Hello from SimpleService!";
    }
}
