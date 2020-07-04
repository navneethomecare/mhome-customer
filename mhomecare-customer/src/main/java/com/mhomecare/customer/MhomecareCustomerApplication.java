package com.mhomecare.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mhomecare.customer.daoimpl.CustomerDAOImpl;
import com.mhomecare.customer.serviceimpl.CustomerServiceImpl;

@SpringBootApplication
public class MhomecareCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MhomecareCustomerApplication.class, args);
	}

	@Bean
	public CustomerServiceImpl getCustomerServiceImpl() {
		return new CustomerServiceImpl();
	}

	@Bean
	public CustomerDAOImpl getCustomerDaoImpl() {
		return new CustomerDAOImpl();
	}

}
