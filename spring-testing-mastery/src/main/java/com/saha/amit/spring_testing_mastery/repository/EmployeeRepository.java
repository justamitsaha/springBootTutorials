package com.saha.amit.spring_testing_mastery.repository;

import com.saha.amit.spring_testing_mastery.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
