package com.satisfiestech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satisfiestech.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}

