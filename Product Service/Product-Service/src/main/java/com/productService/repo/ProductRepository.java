package com.productService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productService.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}

