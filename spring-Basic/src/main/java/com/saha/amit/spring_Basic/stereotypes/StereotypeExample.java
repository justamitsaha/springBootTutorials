package com.saha.amit.spring_Basic.stereotypes;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * REPOSITORY: Marks a class that interacts with the database.
 * Spring provides extra features here like exception translation.
 */
@Repository
class UserRepo {
    public List<String> getUsers() {
        return List.of("Amit", "Saha", "SpringExpert");
    }
}

/**
 * SERVICE: Marks a class for business logic.
 * It sits between the controller and the repository.
 */
@Service
class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void printUsers() {
        System.out.println("Users from Service: " + userRepo.getUsers());
    }
}

public class StereotypeExample {
}
