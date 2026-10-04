package com.saha.amit.spring_testing_mastery.controller;

import com.saha.amit.spring_testing_mastery.entity.Employee;
import com.saha.amit.spring_testing_mastery.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * SLICE TEST: @WebMvcTest only loads the web layer.
 * Best Practice: Use for testing controller mappings, validation, and JSON serialization.
 */
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    void shouldReturnAllEmployees() throws Exception {
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Amit", "amit@example.com")));

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName").value("Amit"));
    }
}
