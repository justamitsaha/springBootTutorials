package com.saha.amit.spring_Basic;

import com.saha.amit.spring_Basic.config.AppConfig;
import com.saha.amit.spring_Basic.di.BusinessLogic;
import com.saha.amit.spring_Basic.di.HighPrioritySearchService;
import com.saha.amit.spring_Basic.di.SearchService;
import com.saha.amit.spring_Basic.stereotypes.StereotypeExample;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBasicApplication.class, args);
		
		System.out.println("--------------------------------------------------");
		System.out.println("1. Container Check: BeanFactory vs ApplicationContext");
		System.out.println("Is Context a BeanFactory? " + (context instanceof BeanFactory));
		System.out.println("Is Context an ApplicationContext? " + (context instanceof ApplicationContext));

		System.out.println("--------------------------------------------------");
		System.out.println("2. Stereotypes and Layering (@Service & @Repository)");
		// Retrieve and execute bean from a layered service
		// In a real project, this would be retrieved from com.saha.amit.spring_Basic.stereotypes package
		// We'll just call the service if we can find it, otherwise show it in code.
		try {
			// Find the service in the context (it was defined in StereotypeExample.java)
			Object userService = context.getBean("userService");
			System.out.println("UserService found in context: " + userService.getClass().getSimpleName());
		} catch (Exception e) {
			System.out.println("Service not found - check if scan includes stereotypes package.");
		}

		System.out.println("--------------------------------------------------");
		System.out.println("3. Java-Based Configuration (@Configuration & @Bean)");
		// This comes from ExternalService in AppConfig
		try {
			Object externalService = context.getBean("externalService");
			// Using reflection to call hello() for simplicity here, or just cast if public.
			System.out.println("External Service Bean found: " + externalService.getClass().getSimpleName());
		} catch (Exception e) {
			System.out.println("ExternalService not found.");
		}

		System.out.println("--------------------------------------------------");
		System.out.println("4. Dependency Resolution Strategies");
		context.getBean(SearchService.class).executeSearch(); // Uses @Primary
		context.getBean(HighPrioritySearchService.class).executeSearch(); // Uses @Qualifier

		System.out.println("--------------------------------------------------");
		System.out.println("5. Circular Dependency handling (via @Lazy)");
		try {
			Object componentA = context.getBean("componentA");
			System.out.println("ComponentA with circular dependency handled: " + componentA.getClass().getSimpleName());
		} catch (Exception e) {
			System.out.println("Circular Dependency failed - check for Lazy fix.");
		}

		System.out.println("--------------------------------------------------");
		System.out.println("6. AOP Demo (Look for [AOP] in logs)");
		context.getBean(BusinessLogic.class).doWork();

		System.out.println("--------------------------------------------------");
		System.out.println("Spring Boot Core Foundation is ready!");
		System.out.println("--------------------------------------------------");
	}

}
