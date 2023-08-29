package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductCat;
import com.example.demo.model.ProductSubCat;

@Repository
public interface ProductCatRepository  extends JpaRepository<ProductCat, Long>{
	
	

}
