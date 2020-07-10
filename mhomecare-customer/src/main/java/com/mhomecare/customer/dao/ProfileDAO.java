package com.mhomecare.customer.dao;

import com.mhomecare.customer.request.ProfileRequest;
import com.mhomecare.customer.response.ProfileResponse;

public interface ProfileDAO {

	public ProfileResponse manageProfile(ProfileRequest profileRequest, String customerId);

}
