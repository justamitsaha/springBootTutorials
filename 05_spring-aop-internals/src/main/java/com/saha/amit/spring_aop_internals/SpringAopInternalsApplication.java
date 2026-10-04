package com.saha.amit.spring_aop_internals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringAopInternalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopInternalsApplication.class, args);
	}

}
