package com.mhomecare.customer.response;

import com.mhomecare.customer.model.Login;

public class LoginResponse {

	private String id;
	private String phoneNumber;
	private Integer otp;
	private Integer countryCode;

	public LoginResponse(Login login) {
		this.id = login.getId();
		this.otp = login.getOtp();
		this.phoneNumber = login.getPhoneNumber();
		this.countryCode = login.getCountryCode();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	
	

}
