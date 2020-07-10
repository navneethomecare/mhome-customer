package com.mhomecare.customer.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mhomecare.customer.request.ProfileRequest;
import com.mhomecare.customer.response.ProfileResponse;
import com.mhomecare.customer.responsetype.SingleResponseObject;
import com.mhomecare.customer.serviceimpl.ProfileServiceImpl;

@RestController
@RequestMapping("/mhomecare/customer")
public class ProfileController {
	@Autowired
	private ProfileServiceImpl profileService;
	
	@Transactional
	@RequestMapping(value = "{customerId}/profile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> manageProfile(@RequestBody ProfileRequest profilerRequest,@PathVariable("customerId") String customerId) {
		ProfileResponse profileResponse = profileService.manageProfile(profilerRequest, customerId);
		SingleResponseObject<String> respObj = new SingleResponseObject<String>(profileResponse.getId());
		return new ResponseEntity<SingleResponseObject<String>>(respObj, HttpStatus.OK);
	}
}
