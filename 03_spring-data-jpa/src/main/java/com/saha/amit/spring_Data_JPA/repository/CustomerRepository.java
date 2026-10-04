package com.saha.amit.spring_Data_JPA.repository;

import com.saha.amit.spring_Data_JPA.entity.Customer;
import com.saha.amit.spring_Data_JPA.projection.CustomerSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c JOIN FETCH c.orders")
    List<Customer> findAllWithOrders();

    List<CustomerSummary> findAllProjectedBy();
}
