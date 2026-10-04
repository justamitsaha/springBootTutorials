package com.saha.amit.spring_Basic.E_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RUNNER: Java-Based Configuration (@Configuration and @Bean).
 */
@SpringBootApplication
public class ConfigRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConfigRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("Java Config Demonstration");
        ExternalService externalService = context.getBean(ExternalService.class);
        externalService.hello();
        System.out.println("--------------------------------------------------");
    }

    static class ExternalService {
        public void hello() {
            System.out.println("Hello from an External Service!");
        }
    }

    /**
     * JAVA-BASED CONFIGURATION
     * Best Practice: Use this when you don't have access to the source code 
     * (3rd party libraries) or when bean creation involves complex logic.
     */
    @Configuration
    static class AppConfig {
        @Bean
        public ExternalService externalService() {
            // Complex initialization can happen here
            return new ExternalService();
        }
    }
}
