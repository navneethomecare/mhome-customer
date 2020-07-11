package com.mhomecare.customer.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhomecare.customer.dao.ProfileDAO;
import com.mhomecare.customer.model.Profile;
import com.mhomecare.customer.persistence.Persistence;
import com.mhomecare.customer.request.ProfileRequest;
import com.mhomecare.customer.response.ProfileResponse;
import com.mhomecare.customer.utils.Utils;
import com.mhomecare.customer.validation.ValidateFromDB;
import com.mhomecare.customer.validation.Validate;

public class ProfileDAOImpl implements ProfileDAO {
	@Autowired
	Persistence persistence;

	@Override
	public ProfileResponse manageProfile(ProfileRequest profileRequest, String customerId) {
		Profile profile = new Profile();
		profile.setId(Utils.generateUniqueId(10));
		profile.setFirstName(profileRequest.getFirstName());
		profile.setLastName(profileRequest.getLastName());
		profile.setProfileImage(profileRequest.getProfileImage());
		profile.setBloodGroup(profileRequest.getBloodGroup());
		profile.setDOB(profileRequest.getDob());
		profile.setGender(profileRequest.getGender());
		profile.setRelation(profileRequest.getRelation());
		profile.setPhoneNumber(profileRequest.getPhoneNumber());
		profile.setCustomerId(customerId);
		persistence.saveObjectToDb(profile);
		ProfileResponse profileResponse = new ProfileResponse(profile);
		return profileResponse;
	}

}
