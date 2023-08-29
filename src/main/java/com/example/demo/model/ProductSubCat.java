package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class ProductSubCat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String subcategory;
	private Long pcid;
	private String desciption;
	
	private Long shopid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public Long getPcid() {
		return pcid;
	}

	public void setPcid(Long pcid) {
		this.pcid = pcid;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	@Override
	public String toString() {
		return "ProductSubCat [id=" + id + ", subcategory=" + subcategory + ", pcid=" + pcid + ", desciption="
				+ desciption + ", shopid=" + shopid + "]";
	}

	public ProductSubCat(Long id, String subcategory, Long pcid, String desciption, Long shopid) {
		super();
		this.id = id;
		this.subcategory = subcategory;
		this.pcid = pcid;
		this.desciption = desciption;
		this.shopid = shopid;
	}
	
	
	

}
