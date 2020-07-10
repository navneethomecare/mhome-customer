package com.mhomecare.customer.dao;

import java.util.List;

import com.mhomecare.customer.model.Customer;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.request.ProfileRequest;
import com.mhomecare.customer.response.CustomerResponse;
import com.mhomecare.customer.response.ProfileResponse;

public interface CustomerDAO {

	public CustomerResponse registerCustomer(CustomerRequest customer);

	public List<CustomerResponse> getCustomers();

	public Customer getCustomerById(String customerId);

	public CustomerResponse updateCustomer(CustomerRequest customer, String customerId);

	public CustomerResponse deleteCustomer(String customerId);

}
