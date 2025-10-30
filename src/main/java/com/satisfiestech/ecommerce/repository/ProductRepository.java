package com.satisfiestech.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satisfiestech.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods if needed
}