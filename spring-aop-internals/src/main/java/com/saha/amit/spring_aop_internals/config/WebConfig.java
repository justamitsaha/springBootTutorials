package com.saha.amit.spring_aop_internals.config;

import com.saha.amit.spring_aop_internals.interceptor.ExecutionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ExecutionInterceptor executionInterceptor;

    public WebConfig(ExecutionInterceptor executionInterceptor) {
        this.executionInterceptor = executionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(executionInterceptor);
    }
}
