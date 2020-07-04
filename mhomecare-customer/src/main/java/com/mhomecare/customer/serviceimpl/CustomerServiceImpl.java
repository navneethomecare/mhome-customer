package com.mhomecare.customer.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhomecare.customer.daoimpl.CustomerDAOImpl;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.response.CustomerResponse;
import com.mhomecare.customer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAOImpl customerDao;

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customer) {
		return customerDao.registerCustomer(customer);
	}

}
