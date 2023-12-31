package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.ProductSubCat;
@Repository
public interface ProductRepo   extends JpaRepository<Product, Long> {

}
