package com.example.demo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductCat {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String category;
	
	private String description;
	
	private Long shopid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductCat [id=" + id + ", category=" + category + ", description=" + description + "]";
	}

	public ProductCat(Long id, String category, String description) {
		super();
		this.id = id;
		this.category = category;
		this.description = description;
	}

	public ProductCat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
