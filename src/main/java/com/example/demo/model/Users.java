package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")

public class Users implements Serializable {

	private static final long serialVersionUID = 123456789L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long userId;

	@Column(name = "First_Name")

	private String firstName;
	@Column(name = "Last_Name")

	private String lastName;

	@Column(name = "username")
	private String username;
	@Column(name = "email")

	private String email;
	@Column(name = "password")

	private String password;

	@Column(name = "role_id")
	private int role_id;

	@Column(name = "mobileNo")

	private String mobileNo;

	@Column(name = "Onboarded_date")

	private LocalDateTime createDate;

	@Column(name = "Modified_date")

	private LocalDateTime modifiedDate;

	@Column(name = "Modified_By")

	private String modifiedBy;

	@Column(name = "status")
	private int status;

	@Column(name = "address")
	private String address;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DukaanUsers [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", email=" + email + ", password=" + password + ", role_id=" + role_id + ", mobileNo="
				+ mobileNo + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", modifiedBy="
				+ modifiedBy + ", status=" + status + ", address=" + address + "]";
	}

}
