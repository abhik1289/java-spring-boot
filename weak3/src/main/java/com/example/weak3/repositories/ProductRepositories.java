package com.example.weak3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.weak3.entities.ProductsEntity;
@Repository
public interface ProductRepositories extends JpaRepository<ProductsEntity,Long> {
    
}
