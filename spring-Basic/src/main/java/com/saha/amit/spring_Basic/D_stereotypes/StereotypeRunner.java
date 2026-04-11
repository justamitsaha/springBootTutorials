package com.saha.amit.spring_Basic.D_stereotypes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RUNNER: Stereotype Annotations (@Component, @Service, @Repository).
 */
@SpringBootApplication
public class StereotypeRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StereotypeRunner.class, args);
        
        System.out.println("--------------------------------------------------");
        System.out.println("Stereotype Demonstration (Service -> Repository)");
        UserService userService = context.getBean(UserService.class);
        userService.printUsers();
        System.out.println("--------------------------------------------------");
    }

    /**
     * REPOSITORY: Best Practice: Use for data access logic.
     * Tells Spring this class communicates with a database and can 
     * automatically translate SQL exceptions into Spring's DataAccessException.
     */
    @Repository
    static class UserRepo {
        public List<String> getUsers() {
            return List.of("Amit", "Saha", "SpringExpert");
        }
    }

    /**
     * SERVICE: Best Practice: Use for business logic.
     * It should be the bridge between the presentation (Controller) 
     * and the data layer (Repository).
     */
    @Service
    static class UserService {
        private final UserRepo userRepo;

        public UserService(UserRepo userRepo) {
            this.userRepo = userRepo;
        }

        public void printUsers() {
            System.out.println("Business Logic: Data from Repository -> " + userRepo.getUsers());
        }
    }
}
