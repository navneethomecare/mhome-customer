package com.mhomecare.customer.response;

import java.util.ArrayList;
import java.util.List;

import com.mhomecare.customer.model.Login;
import com.mhomecare.customer.model.Profile;

public class LoginResponse {

	private String id;
	private String phoneNumber;
	private Integer otp;
	private Integer countryCode;
	private List<ProfileResponse> profileResp;

	public LoginResponse(Login login) {
		this.id = login.getId();
		this.otp = login.getOtp();
		this.phoneNumber = login.getPhoneNumber();
		this.countryCode = login.getCountryCode();

		if (login.getProfile() != null) {
			List<ProfileResponse> profileResponses = new ArrayList<ProfileResponse>();
			for (Profile profile : login.getProfile()) {
				ProfileResponse response = new ProfileResponse(profile);
				profileResponses.add(response);
			}
			this.profileResp = profileResponses;
		}
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

	public List<ProfileResponse> getProfileResp() {
		return profileResp;
	}

	public void setProfileResp(List<ProfileResponse> profileResp) {
		this.profileResp = profileResp;
	}

}
