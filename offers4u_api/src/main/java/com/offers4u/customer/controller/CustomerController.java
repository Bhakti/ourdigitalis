package com.offers4u.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.customer.service.CustomerService;
import com.offers4u.mongodb.domain.Category;
import com.offers4u.mongodb.domain.Customer;
import com.offers4u.mongodb.domain.RecommendedOffer;

@CrossOrigin(maxAge = 3600)
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

	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Customer getCustomersById(@PathVariable("customerId") String customerId) {
		return customerService.getCustomerById(customerId);
	}

	@RequestMapping(value = "/{customerId}/profile", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Customer getCustomersProfileById(@PathVariable("customerId") String customerId) {
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

	@RequestMapping(value = "/{customerId}/preferences", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<Category> getCustomerPreferences(@PathVariable("customerId") String customerId) {
		return customerService.getCustomerPreferences(customerId);
	}

	// Add rest api to update profile with preferences

	// Add rest api to update notifications

	// Add rest api to update recommended offers
	
	
	

	// Add rest api to update recommended offer click - interest shown
	@RequestMapping(value = "/{customerId}/clicked/{offerId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public boolean clickedOffer(@PathVariable("customerId") String customerId,
			@PathVariable("offerId") String offerId) {
		return customerService.clickedOffer(customerId, offerId);
	}

	@RequestMapping(value = "/{customerId}/availed/{offerId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public boolean availedOffer(@PathVariable("customerId") String customerId,
			@PathVariable("offerId") String offerId) {
		return customerService.availedOffer(customerId, offerId);
	}

}