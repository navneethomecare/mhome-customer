package com.mhomecare.customer.validation;

import com.mhomecare.customer.exceptions.InvalidInputException;
import com.mhomecare.customer.request.CustomerRequest;

public class Validate {
	
	
	public static void validateCustomerFields(CustomerRequest request){
		if(request.getName().isEmpty() || request.getName() == null){
			 throw new InvalidInputException("Customer name is missing");
		}
	}

}
