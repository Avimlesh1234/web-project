package com.example.demo.model;

import java.awt.Image;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="product_name")
	private String productname;
	@Column(name="price")
	private String price;
	@Column(name="total_quantity")
	private String totalquantity;
	@Column(name="sell_quantity")
	private String sellquantity;
	@Column(name="serial_Number")
	private  String serialnummber;
	@Column(name="brand_name")
	private String brandname;
	@Column(name="prod_Adress")
	private String address;
	@Column(name="prod_code")
	private String code;
	private String subcategory;
	private Long pcid;
	private String desciption;
	
	private String filename;
	
	@Column(name="prod_image")

	private String image;
	
	private String date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTotalquantity() {
		return totalquantity;
	}
	public void setTotalquantity(String totalquantity) {
		this.totalquantity = totalquantity;
	}
	public String getSellquantity() {
		return sellquantity;
	}
	public void setSellquantity(String sellquantity) {
		this.sellquantity = sellquantity;
	}
	public String getSerialnummber() {
		return serialnummber;
	}
	public void setSerialnummber(String serialnummber) {
		this.serialnummber = serialnummber;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", price=" + price + ", totalquantity="
				+ totalquantity + ", sellquantity=" + sellquantity + ", serialnummber=" + serialnummber + ", brandname="
				+ brandname + ", address=" + address + ", code=" + code + ", subcategory=" + subcategory + ", pcid="
				+ pcid + ", desciption=" + desciption + ", filename=" + filename + ", image=" + image + ", date=" + date
				+ "]";
	}
	
	
	
	
}
