package com.offers4u.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the offers database table.
 * 
 */
@Entity
@Table(name="offers")
//@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="offer_id")
	private String offerId;

	private String description;

	private String details;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	private String image;

	@Column(name="promo_text")
	private String promoText;

	@Column(name="promo_type")
	private String promoType;

	private String reward;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	private BigDecimal subscription;

	@Column(name="t_and_c")
	private String tAndC;

	private String title;

	//uni-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	//uni-directional many-to-one association to Merchant
	@ManyToOne
	@JoinColumn(name="merchant_id")
	private Merchant merchant;

	public Offer() {
	}

	public String getOfferId() {
		return this.offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPromoText() {
		return this.promoText;
	}

	public void setPromoText(String promoText) {
		this.promoText = promoText;
	}

	public String getPromoType() {
		return this.promoType;
	}

	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}

	public String getReward() {
		return this.reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getSubscription() {
		return this.subscription;
	}

	public void setSubscription(BigDecimal subscription) {
		this.subscription = subscription;
	}

	public String getTAndC() {
		return this.tAndC;
	}

	public void setTAndC(String tAndC) {
		this.tAndC = tAndC;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

}