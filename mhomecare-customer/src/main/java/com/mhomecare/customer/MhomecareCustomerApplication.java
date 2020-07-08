package com.mhomecare.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mhomecare.customer.daoimpl.CustomerDAOImpl;
import com.mhomecare.customer.daoimpl.LoginDAOImpl;
import com.mhomecare.customer.persistence.Persistence;
import com.mhomecare.customer.serviceimpl.CustomerServiceImpl;
import com.mhomecare.customer.serviceimpl.LoginServiceImpl;

@SpringBootApplication
public class MhomecareCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MhomecareCustomerApplication.class, args);
	}

	@Bean
	public Persistence getPersistence() {
		return new Persistence();
	}

	@Bean
	public CustomerServiceImpl getCustomerServiceImpl() {
		return new CustomerServiceImpl();
	}

	@Bean
	public CustomerDAOImpl getCustomerDaoImpl() {
		return new CustomerDAOImpl();
	}

	@Bean
	public LoginDAOImpl getLoginDAOImpl() {
		return new LoginDAOImpl();
	}

	@Bean
	public LoginServiceImpl getLoginServiceImpl() {
		return new LoginServiceImpl();
	}

}
