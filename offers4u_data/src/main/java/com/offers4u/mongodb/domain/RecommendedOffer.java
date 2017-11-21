/**
 * 
 */
package com.offers4u.mongodb.domain;

import java.util.Date;

import javax.persistence.Transient;

/**
 * @author Bhakti Atul Pradhan
 *
 */
public class RecommendedOffer {

	private Offer offer;

	private String rollOutType;

	private Date rollOutDate;

	private String comment;

	private String rating;

	@Transient
	private String avgRating;

	// null, Interested, Availed
	private String result;

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public String getRollOutType() {
		return rollOutType;
	}

	public void setRollOutType(String rollOutType) {
		this.rollOutType = rollOutType;
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

	public String getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(String avgRating) {
		this.avgRating = avgRating;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RecommendedOffer [offer=" + offer + ", rollOutType=" + rollOutType + ", rollOutDate=" + rollOutDate
				+ ", comment=" + comment + ", rating=" + rating + ", avgRating=" + avgRating + ", result=" + result
				+ "]";
	}

}
