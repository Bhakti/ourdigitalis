package com.offers4u.mongodb.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "offer")
public class Offer {

	@Id
	private String id;

	private String name;

	// Discount, Cashback, Reward points, Others
	private String offerType;

	private List<String> offersAt;

	private String description;

	private Merchant merchant;

	private Category category;

	private String subCategory;

	private Date startDate;

	private Date endDate;

	private String offerDetails;

	private String howToAvail;

	private String tAndC;

	private Double subscriptionCost;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public List<String> getOffersAt() {
		return offersAt;
	}

	public void setOffersAt(List<String> offersAt) {
		this.offersAt = offersAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOfferDetails() {
		return offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}

	public String getHowToAvail() {
		return howToAvail;
	}

	public void setHowToAvail(String howToAvail) {
		this.howToAvail = howToAvail;
	}

	public String gettAndC() {
		return tAndC;
	}

	public void settAndC(String tAndC) {
		this.tAndC = tAndC;
	}

	public Double getSubscriptionCost() {
		return subscriptionCost;
	}

	public void setSubscriptionCost(Double subscriptionCost) {
		this.subscriptionCost = subscriptionCost;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", offerType=" + offerType + ", offersAt=" + offersAt
				+ ", description=" + description + ", merchant=" + merchant + ", category=" + category
				+ ", subCategory=" + subCategory + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", offerDetails=" + offerDetails + ", howToAvail=" + howToAvail + ", tAndC=" + tAndC
				+ ", subscriptionCost=" + subscriptionCost + "]";
	}

}
