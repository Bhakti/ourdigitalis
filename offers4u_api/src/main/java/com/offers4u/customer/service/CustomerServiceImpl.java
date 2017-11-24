package com.offers4u.customer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.mongodb.domain.Category;
import com.offers4u.mongodb.domain.CategoryData;
import com.offers4u.mongodb.domain.Customer;
import com.offers4u.mongodb.domain.Notification;
import com.offers4u.mongodb.domain.Offer;
import com.offers4u.mongodb.domain.RecommendedOffer;
import com.offers4u.mongodb.repository.CustomerRepository;
import com.offers4u.mongodb.repository.OfferRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OfferRepository offerRepository;

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

	private RecommendedOffer getRecommendedOfferByOfferId(String offerId,
			List<RecommendedOffer> recommendedOffersList) {
		RecommendedOffer retRecommendedOffer = null;
		for (int index = 0; index < recommendedOffersList.size(); index++) {
			RecommendedOffer recommendedOffer = recommendedOffersList.get(index);
			if (offerId != null && recommendedOffer.getOffer() != null
					&& offerId.equalsIgnoreCase(recommendedOffer.getOffer().getOfferId())) {
				retRecommendedOffer = recommendedOffer;
			}
		}
		return retRecommendedOffer;
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
						System.out.println(recommendedOffer.getOffer().getCategory().getCategoryName());

						if (savedCustomer.getCategoryData() != null) {
							for (int j = 0; j < savedCustomer.getCategoryData().size(); j++) {
								CategoryData categoryData = savedCustomer.getCategoryData().get(j);
								if (categoryData.getCategory().getCategoryName().equalsIgnoreCase(
										recommendedOffer.getOffer().getCategory().getCategoryName())) {
									categoryData.setCategory(recommendedOffer.getOffer().getCategory());
									categoryData.setAvailedCount(categoryData.getAvailedCount() + 1);
									savedCustomer.getCategoryData()
											.add(savedCustomer.getCategoryData().indexOf(categoryData), categoryData);
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
				System.out.println(savedCustomer.getCategoryData().toString());
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
						System.out.println(recommendedOffer.getOffer().getCategory().getCategoryName());
						if (savedCustomer.getCategoryData() != null) {
							for (int j = 0; j < savedCustomer.getCategoryData().size(); j++) {
								CategoryData categoryData = savedCustomer.getCategoryData().get(j);

								if (categoryData.getCategory().getCategoryName().equalsIgnoreCase(
										recommendedOffer.getOffer().getCategory().getCategoryName())) {
									System.out.println("category match");
									categoryData.setCategory(recommendedOffer.getOffer().getCategory());
									categoryData.setClickedCount(categoryData.getAvailedCount() + 1);

									savedCustomer.getCategoryData()
											.add(savedCustomer.getCategoryData().indexOf(categoryData), categoryData);
									break;
								}
							}
						} else {
							// customer has first time clicked offer.//create category data
							CategoryData categoryData = new CategoryData();
							categoryData.setCategory(recommendedOffer.getOffer().getCategory());
							categoryData.setClickedCount(1);
							//
							savedCustomer.setCategoryData(new ArrayList<CategoryData>());
							savedCustomer.getCategoryData().add(categoryData);
						}

						savedCustomer.getRecommendedOffers().set(index, recommendedOffer);
						flag = true;
						break;
					}
				}
				System.out.println(savedCustomer.getCategoryData().toString());
				//
				if (flag)
					customerRepository.save(savedCustomer);
			}
		}
		return flag;
	}

	@Override
	public boolean updateCustomerRecommendedOffer(String customerId, List<String> recommendedOffers) {
		if (customerId != null && recommendedOffers != null) {
			Customer savedCustomer = customerRepository.findOne(customerId);
			if (savedCustomer != null) {
				List<RecommendedOffer> newList = new ArrayList<>();
				if (savedCustomer.getRecommendedOffers() != null) {
					for (String offerId : recommendedOffers) {
						RecommendedOffer recommendedOffer = getRecommendedOfferByOfferId(offerId,
								savedCustomer.getRecommendedOffers());
						if (recommendedOffer == null) {
							Offer offer = offerRepository.findByOfferId(offerId);
							if (offer != null) {
								RecommendedOffer newRecommendedOffer = new RecommendedOffer();
								newRecommendedOffer.setOffer(offer);
								newRecommendedOffer.setRollOutDate(new Date());
								newRecommendedOffer.setRecommended(true);
								newList.add(newRecommendedOffer);
								System.out.println("add extra");
							}
						} else {
							// Already in list update recommended flag.
							Offer offer = offerRepository.findByOfferId(offerId);
							if (offer != null) {
								recommendedOffer.setOffer(offer);
							}
							if (!recommendedOffer.isRecommended())
								recommendedOffer.setRollOutDate(new Date());
							recommendedOffer.setRecommended(true);
							savedCustomer.getRecommendedOffers().set(
									savedCustomer.getRecommendedOffers().indexOf(recommendedOffer), recommendedOffer);
							System.out.println("Re rollout not needed");
						}
					}
					// remove / recommend false for not recommended offers
					for (RecommendedOffer recommendedOffer : savedCustomer.getRecommendedOffers()) {
						if (recommendedOffer.getOffer() != null
								&& !recommendedOffers.contains(recommendedOffer.getOffer().getOfferId())) {
							recommendedOffer.setRecommended(false);
							recommendedOffer.setRollOutDate(null);
							System.out.println("Remove not needed");
						}
					}
					//
					savedCustomer.getRecommendedOffers().addAll(newList);
				} else {
					// no offers were suggested
					for (String offerId : recommendedOffers) {
						Offer offer = offerRepository.findByOfferId(offerId);
						if (offer != null) {
							RecommendedOffer newRecommendedOffer = new RecommendedOffer();
							newRecommendedOffer.setOffer(offer);
							newRecommendedOffer.setRecommended(true);
							newRecommendedOffer.setRollOutDate(new Date());
							newList.add(newRecommendedOffer);
						}
					}
					savedCustomer.setRecommendedOffers(newList);
					System.out.println("Adding new");
				}
				System.out.println(savedCustomer.getRecommendedOffers().toString());
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