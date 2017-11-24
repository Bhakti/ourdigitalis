package com.offers4u.common;

import java.util.List;

public class RecommendedOfferRequest {

	private List<String> offers;

	public List<String> getOffers() {
		return offers;
	}

	public void setOffers(List<String> offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "RecommendedOfferRequest [offers=" + offers + "]";
	}

}
