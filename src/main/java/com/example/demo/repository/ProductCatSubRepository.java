package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductSubCat;

@Repository
public interface ProductCatSubRepository  extends JpaRepository<ProductSubCat, Long> {

	List<ProductSubCat> findByPcid(Integer pcid);

}
