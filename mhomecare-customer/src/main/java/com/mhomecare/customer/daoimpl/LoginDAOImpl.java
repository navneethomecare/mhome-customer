package com.mhomecare.customer.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhomecare.customer.dao.LoginDAO;
import com.mhomecare.customer.model.Login;
import com.mhomecare.customer.model.Profile;
import com.mhomecare.customer.persistence.Persistence;
import com.mhomecare.customer.request.LoginRequest;
import com.mhomecare.customer.response.LoginResponse;
import com.mhomecare.customer.validation.ValidateFromDB;
import com.mhomecare.customer.validation.Validate;

public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	Persistence persistence ; 

	@Override
	public LoginResponse loginCustomer(LoginRequest loginRequest) {
		Validate.validateLoginCustomer(loginRequest);
		ValidateFromDB.validateFromDB(loginRequest, persistence);
		Login login = persistence.findCustomerByPhoneNumber(loginRequest.getPhoneNumber());
		List<Profile> profile = persistence.profileDetails(login.getCustomer().getId());
		login.setProfile(profile);
		LoginResponse loginResponse = new LoginResponse(login);
		return loginResponse;
	}
}
