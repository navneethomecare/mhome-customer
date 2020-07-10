package com.mhomecare.customer.service;

import com.mhomecare.customer.request.ProfileRequest;
import com.mhomecare.customer.response.ProfileResponse;

public interface ProfileService {
	
	public ProfileResponse manageProfile(ProfileRequest profileRequest, String customerId);
}
