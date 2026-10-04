package com.saha.amit.spring_testing_mastery.repository;

import com.saha.amit.spring_testing_mastery.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * SLICE TEST: @DataJpaTest only loads JPA components.
 * Best Practice: Use for testing custom queries and repository logic.
 */
@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void shouldSaveAndFindByEmail() {
        Employee employee = new Employee("Amit", "amit@example.com");
        employeeRepository.save(employee);

        Optional<Employee> found = employeeRepository.findByEmail("amit@example.com");

        assertThat(found).isPresent();
        assertThat(found.get().getFirstName()).isEqualTo("Amit");
    }
}
