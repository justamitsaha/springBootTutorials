package com.saha.amit.spring_Data_JPA.repository;

import com.saha.amit.spring_Data_JPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
