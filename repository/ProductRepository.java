package com.example.curse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.curse.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
