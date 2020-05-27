package com.facisa.atividade3.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facisa.atividade3.product.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	

}
