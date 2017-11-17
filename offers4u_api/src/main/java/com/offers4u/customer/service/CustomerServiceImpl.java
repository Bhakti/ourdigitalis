package com.offers4u.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.entity.Category;
import com.offers4u.entity.Customer;
import com.offers4u.entity.Segment;
import com.offers4u.repository.CustomerOfferRepository;
import com.offers4u.repository.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerOfferRepository customerOfferRepository;

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customerRepository.findOne(customerId);
	}

	@Override
	public List<Segment> getCustomerSegments(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProfile(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> getCustomerPreferences(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
