/**
 * 
 */
package com.offers4u.common;

import com.offers4u.mongodb.domain.Offer;

/**
 * @author Atul Pradhan
 *
 */
public class OfferReport {

	private Offer offer;

	private Integer totalRollOuts;

	private Integer totalInterested;

	private Integer totalAvailed;

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Integer getTotalRollOuts() {
		return totalRollOuts;
	}

	public void setTotalRollOuts(Integer totalRollOuts) {
		this.totalRollOuts = totalRollOuts;
	}

	public Integer getTotalInterested() {
		return totalInterested;
	}

	public void setTotalInterested(Integer totalInterested) {
		this.totalInterested = totalInterested;
	}

	public Integer getTotalAvailed() {
		return totalAvailed;
	}

	public void setTotalAvailed(Integer totalAvailed) {
		this.totalAvailed = totalAvailed;
	}

	@Override
	public String toString() {
		return "OfferReport [offer=" + offer + ", totalRollOuts=" + totalRollOuts + ", totalInterested="
				+ totalInterested + ", totalAvailed=" + totalAvailed + "]";
	}

}
