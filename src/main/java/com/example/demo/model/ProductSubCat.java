package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class ProductSubCat {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String subcategory;
	
	private Integer pcid;
	private String desciption;
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
	public Integer getPcid() {
		return pcid;
	}
	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	@Override
	public String toString() {
		return "ProductSubCat [id=" + id + ", subcategory=" + subcategory + ", pcid=" + pcid + ", desciption="
				+ desciption + "]";
	}
	public ProductSubCat(Long id, String subcategory, Integer pcid, String desciption) {
		super();
		this.id = id;
		this.subcategory = subcategory;
		this.pcid = pcid;
		this.desciption = desciption;
	}
	public ProductSubCat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
