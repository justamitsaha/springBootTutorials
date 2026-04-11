package com.saha.amit.spring_Web_Basic.controller;

import com.saha.amit.spring_Web_Basic.config.AppSettings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    private final AppSettings settings;

    public ConfigController(AppSettings settings) {
        this.settings = settings;
    }

    @GetMapping("/api/config")
    public AppSettings getSettings() {
        return settings;
    }
}
