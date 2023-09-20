package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import com.example.demo.model.Product;

@Repository
public interface ProductRepo   extends JpaRepository<Product, Long> {

	
//	@Query(value = "SELECT product FROM  product product WHERE product_name = :value")
//	List<Product> searchproductlist(String key,String value);

}
