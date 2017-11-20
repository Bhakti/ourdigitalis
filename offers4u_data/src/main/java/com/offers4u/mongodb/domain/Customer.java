package com.offers4u.mongodb.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

	@Id
	private String id;

	private String accountNumber;

	// Merchant(he gives offers), endCustomer(who avails deals)
	private String customerType;

	private PersonalDetails personalDetails;

	// when customerType is merchant
	// Merchant merchant;

	// all 4 below when customerType is endCustomer
	private List<Category> categoryPreferences;

	private List<Segment> segments;

	private List<RecommendedOffer> recommendedOffers;

	private List<Notification> notifications;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public List<Category> getCategoryPreferences() {
		return categoryPreferences;
	}

	public void setCategoryPreferences(List<Category> categoryPreferences) {
		this.categoryPreferences = categoryPreferences;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	public List<RecommendedOffer> getRecommendedOffers() {
		return recommendedOffers;
	}

	public void setRecommendedOffers(List<RecommendedOffer> recommendedOffers) {
		this.recommendedOffers = recommendedOffers;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerType=" + customerType + ", accountNumber=" + accountNumber
				+ ", personalDetails=" + personalDetails + ", categoryPreferences=" + categoryPreferences
				+ ", segments=" + segments + ", recommendedOffers=" + recommendedOffers + ", notifications="
				+ notifications + "]";
	}

}
