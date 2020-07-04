package com.mhomecare.customer.service;

import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.response.CustomerResponse;

public interface CustomerService {
	
	public CustomerResponse registerCustomer(CustomerRequest customer);

}
