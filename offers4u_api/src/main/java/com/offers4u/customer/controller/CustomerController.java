package com.offers4u.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.customer.service.CustomerService;
import com.offers4u.mongodb.domain.Customer;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
}