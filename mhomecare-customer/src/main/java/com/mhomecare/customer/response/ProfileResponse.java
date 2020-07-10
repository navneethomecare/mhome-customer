package com.mhomecare.customer.response;

import com.mhomecare.customer.model.Profile;

public class ProfileResponse {

	private String id;
	private String profileImage;
	private String firstName;
	private String lastName;
	private String relation;
	private String dob;
	private String gender;
	private String bloodGroup;
	private String phoneNumber;

	public ProfileResponse(Profile profile) {
		this.id = profile.getId();
		this.profileImage = profile.getProfileImage();
		this.firstName = profile.getFirstName();
		this.lastName = profile.getLastName();
		this.relation = profile.getRelation();
		this.dob = profile.getDOB();
		this.gender = profile.getGender();
		this.bloodGroup = profile.getBloodGroup();
		this.phoneNumber = profile.getPhoneNumber();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
