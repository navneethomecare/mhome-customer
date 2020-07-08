package com.mhomecare.customer.dao;

import com.mhomecare.customer.request.LoginRequest;
import com.mhomecare.customer.response.LoginResponse;

@FunctionalInterface
public interface LoginDAO {
	
	public LoginResponse loginCustomer(LoginRequest loginRequest);

}
