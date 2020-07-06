package com.mhomecare.customer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhomecare.customer.daoimpl.CustomerDAOImpl;
import com.mhomecare.customer.model.Customer;
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

	@Override
	public List<CustomerResponse> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public CustomerResponse updateCustomer(CustomerRequest customerRequest, String customerId) {
		return customerDao.updateCustomer(customerRequest, customerId);
	}

	@Override
	public CustomerResponse deleteCustomer(String customerId) {
		return customerDao.deleteCustomer(customerId);
	}

}
