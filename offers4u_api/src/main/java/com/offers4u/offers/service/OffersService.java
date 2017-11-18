package com.offers4u.offers.service;

import java.util.List;

import com.offers4u.mongodb.domain.Offer;

public interface OffersService {

	List<Offer> getOffers();

	Offer getOffer(String offerId);

	List<Offer> getOffers(String categoryName, String merchantName, String fromDate, String toDate);

	Offer addOffer(Offer offer);

	Offer updateOffer(String offerId, Offer offer);

	boolean deleteOffer(String offerId);

	boolean addOffers(List<Offer> offerList);
}
