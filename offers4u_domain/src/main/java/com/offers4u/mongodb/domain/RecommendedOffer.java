/**
 * 
 */
package com.offers4u.mongodb.domain;

import java.util.Date;

/**
 * @author Bhakti Atul Pradhan
 *
 */
public class RecommendedOffer {

	private Offer offer;

	private Date rollOutDate;

	private String comment;

	private String rating;

	// null, Interested, Availed
	private String result;

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Date getRollOutDate() {
		return rollOutDate;
	}

	public void setRollOutDate(Date rollOutDate) {
		this.rollOutDate = rollOutDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RecommendedOffer [offer=" + offer + ", rollOutDate=" + rollOutDate + ", comment=" + comment
				+ ", rating=" + rating + ", result=" + result + "]";
	}

}
