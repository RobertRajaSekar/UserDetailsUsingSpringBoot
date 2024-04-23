package com.jsp.user.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class User {
	@Id
	private int id;
	@NotNull(message ="Name should not be null")
	@NotBlank(message ="Name should not be blank")
	private String name;
	@NotNull(message ="Address should not be null")
	@NotBlank(message ="Address should not be blank")
	private String address;
	@Min(6000000000l)
	@Max(9999999999l)
	private long phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}
