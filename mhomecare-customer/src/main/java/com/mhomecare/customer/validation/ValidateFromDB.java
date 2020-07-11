package com.mhomecare.customer.validation;

import com.mhomecare.customer.exceptions.DuplicateException;
import com.mhomecare.customer.model.Customer;
import com.mhomecare.customer.model.Login;
import com.mhomecare.customer.model.Profile;
import com.mhomecare.customer.persistence.Persistence;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.request.LoginRequest;
import com.mhomecare.customer.request.ProfileRequest;

public class ValidateFromDB {

	public static void validateFromDB(CustomerRequest customerRequest, Persistence persistence) {
		Customer customer = persistence.checkCustomerPhoneNumberDulicateOrNot(customerRequest.getPhoneNumber());
		if(customer != null){
			throw new DuplicateException("Phone number already exists!");
		}
	}

	public static void validateFromDB(LoginRequest loginRequest, Persistence persistence) {
		Login login = persistence.findCustomerByPhoneNumber(loginRequest.getPhoneNumber());
		if(login != null){
			throw new DuplicateException("Phone number already exists!");
		}
	}

	public static void validateFromDB(ProfileRequest profileRequest, Persistence persistence) {
		Profile profile = persistence.checkProfilePhoneNumberDulicateOrNot(profileRequest.getPhoneNumber());
		if(profile != null){
			throw new DuplicateException("Phone number already exists!");
		}
	}
}
