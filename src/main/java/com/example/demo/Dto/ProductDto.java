package com.example.demo.Dto;

import jakarta.persistence.Column;

public class ProductDto {
	private Long id;
	private String productname;
	private String price;
	private String totalquantity;
	private String sellquantity;
	private String serialnummber;
	private String brandname;
	private String address;
	private String code;
	private String mid;
	private String subcategory;
	private Long pcid;
	private String filename;
	private String image;
	private String createdDate;
	private String updatedDate;
	private String size;
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
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", productname=" + productname + ", price=" + price + ", totalquantity="
				+ totalquantity + ", sellquantity=" + sellquantity + ", serialnummber=" + serialnummber + ", brandname="
				+ brandname + ", address=" + address + ", code=" + code + ", mid=" + mid + ", subcategory="
				+ subcategory + ", pcid=" + pcid + ", filename=" + filename + ", image=" + image + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", size=" + size + "]";
	}
	

}
