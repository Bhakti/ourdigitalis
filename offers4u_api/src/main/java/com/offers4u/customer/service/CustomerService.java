package com.offers4u.customer.service;

import java.util.List;

import com.offers4u.mongodb.domain.Category;
import com.offers4u.mongodb.domain.Customer;
import com.offers4u.mongodb.domain.Notification;
import com.offers4u.mongodb.domain.RecommendedOffer;
import com.offers4u.mongodb.domain.Segment;

public interface CustomerService {

	List<Customer> getCustomers();

	Customer getCustomerById(String customerId);
	
	Customer getCustomerByCardNumber(String customerId);
	
	Customer getCustomerProfileById(String customerId);

	List<Category> getCustomerPreferences(String customerId);

	List<Segment> getCustomerSegments(String customerId);

	List<RecommendedOffer> getCustomerRecommendedOffers(String customerId);

	List<Notification> getCustomerNotification(String customerId);

	//
	boolean updateCustomerProfile(Customer customer);

	// Not needed if done in python
	boolean updateCustomerSegments(String customerId, List<Segment> segments);

	boolean updateCustomerRecommendedOffers(String customerId, List<RecommendedOffer> recommendedOffers);

	// This will be called when endCustomer rates, comments, clicks for interest or
	// avails offer.
	boolean updateCustomerRecommendedOffer(String customerId, RecommendedOffer recommendedOffer);

	boolean updateCustomerNotifications(String customerId, List<Notification> notifications);

}
