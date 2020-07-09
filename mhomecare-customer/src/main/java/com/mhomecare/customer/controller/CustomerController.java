package com.mhomecare.customer.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mhomecare.customer.model.Customer;
import com.mhomecare.customer.request.CustomerRequest;
import com.mhomecare.customer.response.CustomerResponse;
import com.mhomecare.customer.responsetype.ListResponseObject;
import com.mhomecare.customer.responsetype.SingleResponseObject;
import com.mhomecare.customer.serviceimpl.CustomerServiceImpl;
import com.mhomecare.customer.validation.Validate;

@RestController
@RequestMapping("/mhomecare/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;
	
	/**
	 * 
	 * @param customerRequest
	 * @return
	 */
	
	@Transactional
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> customerRegister(@RequestBody CustomerRequest customerRequest) {
		CustomerResponse customerResponse = customerService.registerCustomer(customerRequest);
		SingleResponseObject<String> respObj = new SingleResponseObject<String>(customerResponse.getId());
		return new ResponseEntity<SingleResponseObject<String>>(respObj, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param customerRequest
	 * @param customerId
	 * @return
	 * 
	 */
	
	@Transactional
	@RequestMapping(value = "/{customerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> updateCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable(name = "customerId") String customerId) {
		CustomerResponse customerResponse = customerService.updateCustomer(customerRequest, customerId);
		SingleResponseObject<String> respObj = new SingleResponseObject<String>(customerResponse.getId());
		return new ResponseEntity<SingleResponseObject<String>>(respObj, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListResponseObject<List<CustomerResponse>>> getCustomers() {
		List<CustomerResponse> customerView = customerService.getCustomers();
		ListResponseObject<List<CustomerResponse>> respObj = new ListResponseObject<List<CustomerResponse>>(customerView);
		return new ResponseEntity<ListResponseObject<List<CustomerResponse>>>(respObj, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	
	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<CustomerResponse>> getCustomerById(@PathVariable(name = "customerId") String customerId){
		Customer customer = customerService.getCustomerById(customerId);
		SingleResponseObject<CustomerResponse> respObj = new SingleResponseObject<CustomerResponse>(new CustomerResponse(customer));
		return new ResponseEntity<SingleResponseObject<CustomerResponse>>(respObj, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * 
	 */
	
	@Transactional
	@RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SingleResponseObject<String>> deleteCustomer(@PathVariable(name = "customerId") String customerId) {
		CustomerResponse customerResponse = customerService.deleteCustomer(customerId);
		SingleResponseObject<String> respObj = new SingleResponseObject<String>(customerResponse.getId());
		return new ResponseEntity<SingleResponseObject<String>>(respObj, HttpStatus.OK);
	}
}
