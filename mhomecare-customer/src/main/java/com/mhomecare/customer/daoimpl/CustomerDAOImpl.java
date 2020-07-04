package com.mhomecare.customer.daoimpl;

import com.mhomecare.customer.dao.CustomerDAO;
import com.mhomecare.customer.model.Customer;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.response.CustomerResponse;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customerRequest) {

		Customer customer = new Customer();
		customer.setId("safjlsjl45");
		customer.setName(customerRequest.getName());
		customer.setAge(customerRequest.getAge());
		customer.setEmailId(customerRequest.getEmailId());
		customer.setPhoneNumber(customerRequest.getPhoneNumber());
		customer.setAddress(customerRequest.getAddress());

		CustomerResponse customerResponse = new CustomerResponse(customer);
		return customerResponse;
	}

}
