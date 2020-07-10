package com.mhomecare.customer.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhomecare.customer.daoimpl.ProfileDAOImpl;
import com.mhomecare.customer.request.ProfileRequest;
import com.mhomecare.customer.response.ProfileResponse;
import com.mhomecare.customer.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileDAOImpl profileDAOImpl;

	@Override
	public ProfileResponse manageProfile(ProfileRequest profileRequest, String customerId) {
		return profileDAOImpl.manageProfile(profileRequest,customerId);
	}

}
