package com.saha.amit.spring_Web_Basic;

import com.saha.amit.spring_Web_Basic.config.AppSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AppSettings.class)
@SpringBootApplication
public class SpringWebBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebBasicApplication.class, args);
	}

}
