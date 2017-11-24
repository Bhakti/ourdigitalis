package com.offers4u.mongodb.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "offer")
public class Offer {

	@Id
	private String id;

	private String offerId;

	private String name;

	// Discount, Cashback, Reward points, Others
	private String offerType;

	private String description;

	private Date startDate;

	private Date endDate;

	@Transient
	private String startDateStr;

	@Transient
	private String endDateStr;

	@Transient
	private String offerStatus;

	private List<String> offersAt;

	private String offerDetails;

	private String tAndC;

	private Merchant merchant;

	private Double subscriptionCost;

	private Category category;

	private List<Segment> segments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/YYYY");
		this.setStartDateStr(sf.format(startDate));
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/YYYY");
		this.setEndDateStr(sf.format(endDate));
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;

	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getOfferDetails() {
		return offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
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

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", offerId=" + offerId + ", name=" + name + ", offerType=" + offerType
				+ ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", offerStatus=" + offerStatus + ", offersAt=" + offersAt + ", offerDetails=" + offerDetails
				+ ", tAndC=" + tAndC + ", merchant=" + merchant + ", subscriptionCost=" + subscriptionCost
				+ ", category=" + category + ", segments=" + segments + "]";
	}

}
