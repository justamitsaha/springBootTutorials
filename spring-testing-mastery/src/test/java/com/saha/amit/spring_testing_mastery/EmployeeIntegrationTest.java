package com.saha.amit.spring_testing_mastery;

import com.saha.amit.spring_testing_mastery.entity.Employee;
import com.saha.amit.spring_testing_mastery.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * INTEGRATION TEST: @SpringBootTest with Testcontainers.
 * Best Practice: Use real infrastructure (Docker) for integration tests to 
 * avoid "H2 works but Postgres fails" scenarios.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class EmployeeIntegrationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void connectionEstablished() {
        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    void shouldCreateEmployeeInRealPostgres() {
        Employee employee = new Employee("Amit", "amit@postgres.com");
        
        ResponseEntity<Employee> response = restTemplate.postForEntity("/api/employees", employee, Employee.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(employeeRepository.findAll()).hasSize(1);
        assertThat(employeeRepository.findByEmail("amit@postgres.com")).isPresent();
    }
}
