package com.offers4u.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the customer_offers database table.
 * 
 */
@Entity
@Table(name="customer_offers")
//@NamedQuery(name="CustomerOffer.findAll", query="SELECT c FROM CustomerOffer c")
public class CustomerOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String feedback;

	private String rating;

	private String result;

	@Temporal(TemporalType.DATE)
	@Column(name="roll_out_date")
	private Date rollOutDate;

	//uni-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Offer
	@ManyToOne
	@JoinColumn(name="offer_id")
	private Offer offer;

	public CustomerOffer() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getRollOutDate() {
		return this.rollOutDate;
	}

	public void setRollOutDate(Date rollOutDate) {
		this.rollOutDate = rollOutDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}