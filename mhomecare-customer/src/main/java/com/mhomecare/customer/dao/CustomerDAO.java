package com.mhomecare.customer.dao;

import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.response.CustomerResponse;

public interface CustomerDAO {

	public CustomerResponse registerCustomer(CustomerRequest customer);

}
