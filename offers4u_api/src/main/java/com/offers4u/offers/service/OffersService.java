package com.offers4u.offers.service;

import java.util.List;

import com.offers4u.entity.Offer;

public interface OffersService {

	List<Offer> getOffers();

	List<Offer> getOffers(String categoryId, String merchantId);

	Offer getOffer(String offerId);
}
