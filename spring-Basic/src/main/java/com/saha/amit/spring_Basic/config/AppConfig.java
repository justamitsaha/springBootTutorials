package com.saha.amit.spring_Basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class ExternalService {
    public void hello() {
        System.out.println("Hello from an External Service (defined via @Bean)!");
    }
}

/**
 * JAVA-BASED CONFIGURATION:
 * Used when you don't have access to the source code to add @Component,
 * or when you need complex initialization logic.
 */
@Configuration
public class AppConfig {

    @Bean
    public ExternalService externalService() {
        // You can add logic here before returning the bean
        return new ExternalService();
    }
}
