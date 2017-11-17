package com.offers4u.customer.service;

import java.util.List;

import com.offers4u.entity.Category;
import com.offers4u.entity.Customer;
import com.offers4u.entity.Segment;

public interface CustomerService {

	List<Customer> getCustomers();

	Customer getCustomerById(String customerId);

	List<Category> getCustomerPreferences(String customerId);
	
	List<Segment> getCustomerSegments(String customerId);
	
	void updateProfile(Customer customer);

}
