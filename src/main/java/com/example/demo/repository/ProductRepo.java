package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Dto.SearchDto;
import com.example.demo.model.Product;
import com.example.demo.model.ProductSubCat;
@Repository
public interface ProductRepo   extends JpaRepository<Product, Long> {

	
	
	@Query(value = "SELECT * FROM  product WHERE ?1 = ?2", nativeQuery = true)
	List<Product> searchproductlist(String key,String value);

}
