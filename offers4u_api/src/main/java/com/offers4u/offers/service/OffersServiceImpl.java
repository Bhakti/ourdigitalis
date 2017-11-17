package com.offers4u.offers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.entity.Offer;
import com.offers4u.repository.OfferRepository;

@Service("offerService")
@Transactional
public class OffersServiceImpl implements OffersService {

	@Autowired
	private OfferRepository offerRepository;

	@Override
	public List<Offer> getOffers() {
		return offerRepository.findAll();
	}

	@Override
	public Offer getOffer(String offerId) {
		return offerRepository.findOne(offerId);
	}

	@Override
	public List<Offer> getOffers(String categoryId, String merchantId) {
		// TODO Auto-generated method stub
		return null;
	}
}
