package com.offers4u.customer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.mongodb.domain.Category;
import com.offers4u.mongodb.domain.CategoryData;
import com.offers4u.mongodb.domain.Customer;
import com.offers4u.mongodb.domain.Notification;
import com.offers4u.mongodb.domain.RecommendedOffer;
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
	public Customer getCustomerByCardNumber(String cardNumber) {
		return customerRepository.findByCardNumber(cardNumber);
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
	public boolean updateCustomerRecommendedOffer(String customerId, RecommendedOffer recommendedOffer) {
		// TO DO
		// Incomplete
		if (customerId != null) {
			//
			Customer savedCustomer = customerRepository.findOne(customerId);
			//
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
	public boolean availedOffer(String customerId, String offerId) {
		boolean flag = false;
		if (customerId != null) {
			Customer savedCustomer = customerRepository.findOne(customerId);
			if (savedCustomer != null) {
				for (int index = 0; index < savedCustomer.getRecommendedOffers().size(); index++) {
					RecommendedOffer recommendedOffer = savedCustomer.getRecommendedOffers().get(index);
					if (offerId.equalsIgnoreCase(recommendedOffer.getOffer().getOfferId())) {
						recommendedOffer.setAvailedDate(new Date());
						if (savedCustomer.getCategoryData() != null) {
							for (int j = 0; j < savedCustomer.getCategoryData().size(); j++) {
								CategoryData categoryData = savedCustomer.getCategoryData().get(j);
								if (categoryData.getCategory().getCategoryName().equalsIgnoreCase(
										recommendedOffer.getOffer().getCategory().getCategoryName())) {
									categoryData.setCategory(recommendedOffer.getOffer().getCategory());
									categoryData.setAvailedCount(categoryData.getAvailedCount() + 1);
									savedCustomer.getCategoryData().add(categoryData);
									break;
								}
							}
						} else {
							CategoryData categoryData = new CategoryData();
							categoryData.setCategory(recommendedOffer.getOffer().getCategory());
							categoryData.setAvailedCount(1);
							savedCustomer.setCategoryData(new ArrayList<CategoryData>());
							savedCustomer.getCategoryData().add(categoryData);
						}
						savedCustomer.getRecommendedOffers().set(index, recommendedOffer);
						flag = true;
						break;
					}
				}
				//
				if (flag)
					customerRepository.save(savedCustomer);
			}
		}
		return flag;
	}

	@Override
	public boolean clickedOffer(String customerId, String offerId) {
		boolean flag = false;
		if (customerId != null) {
			Customer savedCustomer = customerRepository.findOne(customerId);
			if (savedCustomer != null) {
				for (int index = 0; index < savedCustomer.getRecommendedOffers().size(); index++) {
					RecommendedOffer recommendedOffer = savedCustomer.getRecommendedOffers().get(index);
					if (offerId.equalsIgnoreCase(recommendedOffer.getOffer().getOfferId())) {
						recommendedOffer.setClickedDate(new Date());
						if (savedCustomer.getCategoryData() != null) {
							for (int j = 0; j < savedCustomer.getCategoryData().size(); j++) {
								CategoryData categoryData = savedCustomer.getCategoryData().get(j);
								if (categoryData.getCategory().getCategoryName().equalsIgnoreCase(
										recommendedOffer.getOffer().getCategory().getCategoryName())) {
									categoryData.setCategory(recommendedOffer.getOffer().getCategory());
									categoryData.setClickedCount(categoryData.getAvailedCount() + 1);
									savedCustomer.getCategoryData().add(categoryData);
									break;
								}
							}
						} else {
							CategoryData categoryData = new CategoryData();
							categoryData.setCategory(recommendedOffer.getOffer().getCategory());
							categoryData.setClickedCount(1);
							savedCustomer.setCategoryData(new ArrayList<CategoryData>());
							savedCustomer.getCategoryData().add(categoryData);
						}

						savedCustomer.getRecommendedOffers().set(index, recommendedOffer);
						flag = true;
						break;
					}
				}
				//
				if (flag)
					customerRepository.save(savedCustomer);
			}
		}
		return flag;
	}

}