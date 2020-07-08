package com.mhomecare.customer.service;

import com.mhomecare.customer.request.LoginRequest;
import com.mhomecare.customer.response.LoginResponse;

@FunctionalInterface
public interface LoginService {
	
	public LoginResponse loginCustomer(LoginRequest loginRequest);

}
