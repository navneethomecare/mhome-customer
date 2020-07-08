package com.mhomecare.customer.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhomecare.customer.daoimpl.LoginDAOImpl;
import com.mhomecare.customer.request.LoginRequest;
import com.mhomecare.customer.response.LoginResponse;
import com.mhomecare.customer.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAOImpl loginDAOImpl;

	@Override
	public LoginResponse loginCustomer(LoginRequest loginRequest) {
		return loginDAOImpl.loginCustomer(loginRequest);
	}

}
