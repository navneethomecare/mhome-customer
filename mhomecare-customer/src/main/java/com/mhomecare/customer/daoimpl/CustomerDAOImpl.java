package com.mhomecare.customer.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhomecare.customer.dao.CustomerDAO;
import com.mhomecare.customer.model.Customer;
import com.mhomecare.customer.persistence.Persistence;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.response.CustomerResponse;
import com.mhomecare.customer.utils.Utils;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	Persistence persistence ; 

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		customer.setId(Utils.generateUniqueId(10));
		customer.setName(customerRequest.getName());
		customer.setAge(customerRequest.getAge());
		customer.setEmailId(customerRequest.getEmailId());
		customer.setPhoneNumber(customerRequest.getPhoneNumber());
		customer.setAddress(customerRequest.getAddress());
		persistence.saveObjectToDb(customer);
		CustomerResponse customerResponse = new CustomerResponse(customer);
		return customerResponse;
	}
}
