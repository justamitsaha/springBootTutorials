package com.saha.amit.spring_security_pro.repository;

import com.saha.amit.spring_security_pro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
