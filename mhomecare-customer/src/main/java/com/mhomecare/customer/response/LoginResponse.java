package com.mhomecare.customer.response;

import com.mhomecare.customer.model.Login;

public class LoginResponse {

	private String id;
	private String phoneNumber;
	private Integer otp;

	public LoginResponse(Login login) {
		this.id = login.getId();
		this.otp = login.getOtp();
		this.phoneNumber = login.getPhoneNumber();
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

}
