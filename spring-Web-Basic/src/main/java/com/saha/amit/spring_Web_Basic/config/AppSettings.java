package com.saha.amit.spring_Web_Basic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.Map;

/**
 * BEST PRACTICE: ConfigurationProperties for type-safe config.
 */
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppSettings {
    private String name;
    private String environment;
    private Map<String, String> features;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }
    public Map<String, String> getFeatures() { return features; }
    public void setFeatures(Map<String, String> features) { this.features = features; }
}
