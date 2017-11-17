package com.offers4u.offers.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.mongodb.domain.Offer;
import com.offers4u.mongodb.repository.OfferRepository;

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
	public Offer addOffer(Offer offer) {
		Offer savedOffer = offerRepository.save(offer);
		return savedOffer;
	}

	@Override
	public Offer updateOffer(String offerId, Offer offer) {
		Offer updatedOffer = null;
		if (offerRepository.exists(offerId)) {
			updatedOffer = offerRepository.save(offer);
		}
		return updatedOffer;
	}

	@Override
	public boolean deleteOffer(String offerId) {
		if (offerRepository.exists(offerId)) {
			offerRepository.delete(offerId);
			return true;
		}
		return false;
	}

	@Override
	public List<Offer> getOffers(String categoryId, String merchantId, String fromDate, String toDate) {
		List<Offer> offerList = new ArrayList<>();
		if (categoryId != null && !categoryId.trim().isEmpty() && merchantId != null && !merchantId.trim().isEmpty()) {

		} else if (categoryId != null && !categoryId.trim().isEmpty()) {
		} else if (merchantId != null && !merchantId.trim().isEmpty()) {

		}
		// TODO Date logic

		return offerList;
	}

	@Override
	public boolean addOffers(List<Offer> offerList) {
		// TODO Auto-generated method stub
		return false;
	}
}
