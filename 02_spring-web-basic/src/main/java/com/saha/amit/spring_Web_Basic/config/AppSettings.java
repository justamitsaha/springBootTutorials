package com.saha.amit.spring_Web_Basic.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * BEST PRACTICE: ConfigurationProperties for type-safe config.
 */
@Setter
@Getter
@ConfigurationProperties(value = "app")
public class AppSettings {
    private String name;
    private String environment;
    private Map<String, String> features;
}
