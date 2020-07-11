package com.mhomecare.customer.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mhomecare.customer.dao.CustomerDAO;
import com.mhomecare.customer.model.Customer;
import com.mhomecare.customer.model.Login;
import com.mhomecare.customer.persistence.Persistence;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.response.CustomerResponse;
import com.mhomecare.customer.utils.Utils;
import com.mhomecare.customer.validation.ValidateFromDB;
import com.mhomecare.customer.validation.Validate;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	Persistence persistence ; 
	
	/**
	 * Description : Register new customer 
	 */
	

	@Override
	public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		customer.setId(Utils.generateUniqueId(10));
		customer.setName(customerRequest.getName());
		customer.setAge(customerRequest.getAge());
		customer.setEmailId(customerRequest.getEmailId());
		customer.setPhoneNumber(customerRequest.getPhoneNumber());
		customer.setAddress(customerRequest.getAddress());
		customer.setImageUrl(customerRequest.getImagesUrl());
		Login login = new Login();
		login.setId(Utils.generateUniqueId(10));
		login.setPhoneNumber(customerRequest.getPhoneNumber());
		login.setOtp(1234);
		login.setCountryCode(customerRequest.getCountryCode());
		customer.setLogin(login);
		login.setCustomer(customer);
		persistence.saveObjectToDb(customer);
		CustomerResponse customerResponse = new CustomerResponse(customer);
		return customerResponse;
	}
	
	/**
	 * @ Description : get list of customer which are not deleted
	 */

	@Override
	public List<CustomerResponse> getCustomers() {
		List<Customer> customers = persistence.getAllCustomers();
		List<CustomerResponse> customerResponses = new ArrayList<>();
		for(Customer customer : customers){
			customerResponses.add(new CustomerResponse(customer));
		}
		return customerResponses;
	}
	
	/**
	 * @Description : get specific customer from customer list
	 */

	@Override
	public Customer getCustomerById(String customerId) {
		Customer customer = persistence.getCustomerById(customerId);
		return customer;
	}
	
	/**
	 * @Description : update specific customer  
	 */

	@Override
	public CustomerResponse updateCustomer(CustomerRequest customerRequest, String customerId) {
		Customer customer = persistence.getCustomerById(customerId);
		customer.setName(customerRequest.getName());
		customer.setAge(customerRequest.getAge());
		customer.setEmailId(customerRequest.getEmailId());
		customer.setPhoneNumber(customerRequest.getPhoneNumber());
		customer.setAddress(customerRequest.getAddress());
		customer.setImageUrl(customerRequest.getImagesUrl());
		persistence.mergeObjectToDb(customer);
		CustomerResponse customerResponse = new CustomerResponse(customer);
		return customerResponse;
	}
	
	/**
	 * @Description : delete specific customer  
	 */

	@Override
	public CustomerResponse deleteCustomer(String customerId) {
		Customer customer = persistence.getCustomerById(customerId);
		customer.setDeleted(true);
		persistence.mergeObjectToDb(customer);
		CustomerResponse customerResponse = new CustomerResponse(customer);
		return customerResponse;
	}

}
