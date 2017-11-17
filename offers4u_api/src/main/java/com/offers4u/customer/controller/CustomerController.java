package com.offers4u.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.customer.service.CustomerService;
import com.offers4u.entity.Customer;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
}