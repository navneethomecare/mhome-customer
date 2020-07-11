package com.mhomecare.customer.validation;

import com.mhomecare.customer.exceptions.InvalidInputException;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.request.LoginRequest;
import com.mhomecare.customer.request.ProfileRequest;

public class Validate {
	
	
	public static void validateCustomerFields(CustomerRequest request){
		if(request.getName().isEmpty() || request.getName() == null){
			 throw new InvalidInputException("Customer name is missing!");
		}
		if(request.getAge() <  0 || request.getAge() == null){
			 throw new InvalidInputException("Customer age is missing!");
		}
		if(request.getAddress().isEmpty() || request.getAddress() == null){
			 throw new InvalidInputException("Customer address is missing!");
		}
		if(request.getEmailId().isEmpty() || request.getEmailId() == null){
			 throw new InvalidInputException("Customer email id is missing!");
		}
		if(request.getPhoneNumber().isEmpty() || request.getPhoneNumber() == null){
			 throw new InvalidInputException("Customer phone number is missing!");
		}
	}
	
	public static void validateLoginCustomer(LoginRequest loginRequest){
		if(loginRequest.getPhoneNumber().isEmpty()){
			 throw new InvalidInputException("phone number is missing!!");
		}
		if(loginRequest.getCountryCode().SIZE == 0){
			 throw new InvalidInputException("Country code is missing!!");
		}
	}
	
	public static void validateProfileFields(ProfileRequest profileRequest){
		if(!profileRequest.getFirstName().isEmpty()){
			throw new InvalidInputException("First name is missing!");
		}
		if(!profileRequest.getLastName().isEmpty()){
			throw new InvalidInputException("Last name is missing!");
		}
		if(!profileRequest.getRelation().isEmpty()){
			throw new InvalidInputException("Relation is missing!");
		}
		if(!profileRequest.getDob().isEmpty()){
			throw new InvalidInputException("DOB is missing!");
		}
		if(!profileRequest.getGender().isEmpty()){
			throw new InvalidInputException("Gender is missing!");
		}
	}
}
