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

import com.mhomecare.customer.request.LoginRequest;
import com.mhomecare.customer.response.LoginResponse;
import com.mhomecare.customer.responsetype.SingleResponseObject;
import com.mhomecare.customer.serviceimpl.LoginServiceImpl;

@RestController
@RequestMapping("/mhomecare/login")
public class LoginController {
	@Autowired
	private LoginServiceImpl customerService;
	
	@Transactional
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> login(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = customerService.loginCustomer(loginRequest);
		SingleResponseObject<String> respObj = new SingleResponseObject<String>(loginResponse.getId());
		return new ResponseEntity<SingleResponseObject<String>>(respObj, HttpStatus.OK);
	}
}
