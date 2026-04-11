package com.saha.amit.spring_Data_JPA.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CustomerSummary {
    Long getId();
    String getName();

    @Value("#{target.name.toUpperCase()}")
    String getUpperName();
}
