package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "merchant_Name")
	private String merchantName;
	@Column(name = "shop_Name")

	private String shopName;
	
	@Column(name = "shop_regId")
	private String shopregId;
	@Column(name = "gst_Number")
	private String gstNumber;	
	@Column(name = "shop_year")
	private String shopyear;
	@Column(name = "owner_Shop")
	private String ownerShop;
	@Column(name = "account_Number")
	private String accountNumber;
	@Column(name = "accoun_Branch")
	private String accountBranch;
	@Column(name = "address")
	private String address;	
	@Column(name = "address2")
	private String address2;
	@Column(name = "bank_Name")
	private String bankName;
	@Column(name = "pan_No")
	private String panNo;
	@Column(name = "email_Address")
	private String email;	
	@Column(name = "phone1")
	private String phone1;
	@Column(name = "phone2")
	private String phone2;
	@Column(name = "city")
	private String city;	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "card_Type")
	private String cardType;
	private String status;
	@Column(name = "merge_Owner")
	private String mergeOwner;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopregId() {
		return shopregId;
	}
	public void setShopregId(String shopregId) {
		this.shopregId = shopregId;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getShopyear() {
		return shopyear;
	}
	public void setShopyear(String shopyear) {
		this.shopyear = shopyear;
	}
	public String getOwnerShop() {
		return ownerShop;
	}
	public void setOwnerShop(String ownerShop) {
		this.ownerShop = ownerShop;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountBranch() {
		return accountBranch;
	}
	public void setAccountBranch(String accountBranch) {
		this.accountBranch = accountBranch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMergeOwner() {
		return mergeOwner;
	}
	public void setMergeOwner(String mergeOwner) {
		this.mergeOwner = mergeOwner;
	}
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", merchantName=" + merchantName + ", shopName=" + shopName + ", shopregId="
				+ shopregId + ", gstNumber=" + gstNumber + ", shopyear=" + shopyear + ", ownerShop=" + ownerShop
				+ ", accountNumber=" + accountNumber + ", accountBranch=" + accountBranch + ", address=" + address
				+ ", address2=" + address2 + ", bankName=" + bankName + ", panNo=" + panNo + ", email=" + email
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + ", cardType=" + cardType + ", status=" + status + ", mergeOwner=" + mergeOwner + "]";
	}
	
	
	

	
	
	
	
	
}
