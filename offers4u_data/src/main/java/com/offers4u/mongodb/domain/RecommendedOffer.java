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

	private Date clickedDate;

	private Date availedDate;

	private boolean isRecommended;

	// null, Interested, Availed
	private String result;

	private String comment;

	private String rating;

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

	public Date getClickedDate() {
		return clickedDate;
	}

	public void setClickedDate(Date clickedDate) {
		this.clickedDate = clickedDate;
	}

	public Date getAvailedDate() {
		return availedDate;
	}

	public void setAvailedDate(Date availedDate) {
		this.availedDate = availedDate;
	}

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	@Override
	public String toString() {
		return "RecommendedOffer [offer=" + offer + ", rollOutDate=" + rollOutDate + ", clickedDate=" + clickedDate
				+ ", availedDate=" + availedDate + ", isRecommended=" + isRecommended + ", result=" + result
				+ ", comment=" + comment + ", rating=" + rating + "]";
	}

}
