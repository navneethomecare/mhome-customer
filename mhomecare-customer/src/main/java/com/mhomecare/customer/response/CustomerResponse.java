package com.mhomecare.customer.response;

import com.mhomecare.customer.model.Customer;

public class CustomerResponse {

	private String id;
	private String name;
	private Integer age;
	private String emailId;
	private String phoneNumber;
	private String address;
	private String imageUrl;

	public CustomerResponse(Customer customer) {

		this.id = customer.getId();
		this.name = customer.getName();
		this.age = customer.getAge();
		this.emailId = customer.getEmailId();
		this.phoneNumber = customer.getPhoneNumber();
		this.address = customer.getAddress();
		this.imageUrl = customer.getImageUrl();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

}
