package com.offers4u.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.mongodb.domain.Category;
import com.offers4u.mongodb.domain.Customer;
import com.offers4u.mongodb.domain.Notification;
import com.offers4u.mongodb.domain.RecommendedOffer;
import com.offers4u.mongodb.domain.Segment;
import com.offers4u.mongodb.repository.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customerRepository.findOne(customerId);
	}

	
	@Override
	public Customer getCustomerProfileById(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Category> getCustomerPreferences(String customerId) {
		return customerRepository.findOne(customerId).getCategoryPreferences();
	}

	@Override
	public List<Segment> getCustomerSegments(String customerId) {
		return customerRepository.findOne(customerId).getSegments();
	}

	@Override
	public List<RecommendedOffer> getCustomerRecommendedOffers(String customerId) {
		return customerRepository.findOne(customerId).getRecommendedOffers();
	}

	@Override
	public List<Notification> getCustomerNotification(String customerId) {
		return customerRepository.findOne(customerId).getNotifications();
	}

	@Override
	public boolean updateCustomerProfile(Customer customer) {
		if (customer != null) {
			Customer savedCustomer = customerRepository.findOne(customer.getId());
			if (savedCustomer != null) {
				savedCustomer.setPersonalDetails(customer.getPersonalDetails());
				savedCustomer.setCategoryPreferences(customer.getCategoryPreferences());
				savedCustomer = customerRepository.save(savedCustomer);
				if (savedCustomer != null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomerSegments(String customerId, List<Segment> segments) {
		if (customerId != null) {
			Customer savedCustomer = customerRepository.findOne(customerId);
			if (savedCustomer != null) {
				savedCustomer.setSegments(segments);
				savedCustomer = customerRepository.save(savedCustomer);
				if (savedCustomer != null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomerRecommendedOffers(String customerId, List<RecommendedOffer> recommendedOffers) {
		if (customerId != null) {
			Customer savedCustomer = customerRepository.findOne(customerId);
			if (savedCustomer != null) {
				savedCustomer.setRecommendedOffers(recommendedOffers);
				savedCustomer = customerRepository.save(savedCustomer);
				if (savedCustomer != null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomerRecommendedOffer(String customerId, RecommendedOffer recommendedOffer) {
		// TO DO
		// Incomplete
		if (customerId != null) {
			//
			Customer savedCustomer = customerRepository.findOne(customerId);
			if (savedCustomer != null) {
				savedCustomer = customerRepository.save(savedCustomer);
				if (savedCustomer != null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomerNotifications(String customerId, List<Notification> notifications) {
		if (customerId != null) {
			Customer savedCustomer = customerRepository.findOne(customerId);
			if (savedCustomer != null) {
				savedCustomer.setNotifications(notifications);
				savedCustomer = customerRepository.save(savedCustomer);
				if (savedCustomer != null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

}