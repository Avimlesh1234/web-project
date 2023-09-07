package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Merchant;
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

	 @Query(value = "SELECT * FROM Merchant WHERE id = :mid", nativeQuery = true)
	Merchant findByid(@Param("mid")Long mid);

	
}
