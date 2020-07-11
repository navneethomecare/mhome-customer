package com.mhomecare.customer.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mhomecare.customer.persistence.Persistence;
import com.mhomecare.customer.request.LoginRequest;
import com.mhomecare.customer.response.LoginResponse;
import com.mhomecare.customer.responsetype.SingleResponseObject;
import com.mhomecare.customer.serviceimpl.LoginServiceImpl;
import com.mhomecare.customer.validation.Validate;
import com.mhomecare.customer.validation.ValidateFromDB;

@RestController
@RequestMapping("/mhomecare/login")
public class LoginController {
	@Autowired
	private LoginServiceImpl customerService;
	

	@Autowired
	Persistence persistence;
	
	@Transactional
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
		Validate.validateLoginCustomer(loginRequest);
		LoginResponse loginResponse = customerService.loginCustomer(loginRequest);
		SingleResponseObject<LoginResponse> respObj = new SingleResponseObject<LoginResponse>(loginResponse);
		return new ResponseEntity<SingleResponseObject<LoginResponse>>(respObj, HttpStatus.OK);
	}
}
