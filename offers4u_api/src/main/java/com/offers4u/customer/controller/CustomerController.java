package com.offers4u.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.customer.service.CustomerService;
import com.offers4u.mongodb.domain.Customer;
import com.offers4u.mongodb.domain.RecommendedOffer;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Customer getCustomersById(@PathVariable("customerId") String customerId) {
		return customerService.getCustomerById(customerId);
	}

	@RequestMapping(value = "/{customerId}/offers", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<RecommendedOffer> getCustomerOffer(@PathVariable("customerId") String customerId,
			@RequestParam(name = "category", required = false) String categoryName,
			@RequestParam(name = "merchant", required = false) String merchantName,
			@RequestParam(name = "fromDate", required = false) String fromDate,
			@RequestParam(name = "toDate", required = false) String toDate) {
		return customerService.getCustomerRecommendedOffers(customerId);
	}

	@RequestMapping(value = "/{customerId}/notifications", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<Customer> getCustomerNotifications(@PathVariable("customerId") String customerId,
			@RequestParam(name = "fromDate", required = false) String fromDate,
			@RequestParam(name = "toDate", required = false) String toDate) {
		return customerService.getCustomers();
	}

}