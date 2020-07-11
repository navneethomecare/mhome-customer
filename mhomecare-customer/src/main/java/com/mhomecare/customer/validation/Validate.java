package com.mhomecare.customer.validation;

import com.mhomecare.customer.exceptions.AuthorizationException;
import com.mhomecare.customer.exceptions.DuplicateException;
import com.mhomecare.customer.exceptions.InvalidInputException;
import com.mhomecare.customer.model.Login;
import com.mhomecare.customer.persistence.Persistence;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.request.LoginRequest;

public class Validate {
	
	
	public static void validateCustomerFields(CustomerRequest request, Login login,Persistence persistence){
		login = persistence.findCustomerByPhoneNumber(request.getPhoneNumber());
		if(login != null){
			 throw new DuplicateException("Phone number already exists!");
		}
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
	
	public static void validateLoginCustomer(LoginRequest loginRequest, Login login, Persistence persistence){
		if(login == null || !login.getPhoneNumber().equalsIgnoreCase(loginRequest.getPhoneNumber())){
			 throw new AuthorizationException("Invalid phone number!");
		}
	}
}
