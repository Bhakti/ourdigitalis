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
	public List<Offer> getOffers(String categoryName, String merchantName, String fromDate, String toDate) {
		// TO DO date -- to filter expired offers. ongoing and future can be shown.
		List<Offer> offerList = new ArrayList<>();
		if (categoryName != null && !categoryName.trim().isEmpty() && merchantName != null
				&& !merchantName.trim().isEmpty()) {
			offerList = offerRepository.findByCategoryNameMerchantName(categoryName, merchantName);
		} else if (categoryName != null && !categoryName.trim().isEmpty()) {
			offerList = offerRepository.findByCategoryName(categoryName);

		} else if (merchantName != null && !merchantName.trim().isEmpty()) {
			offerList = offerRepository.findByMerchantName(merchantName);
		} else {
			offerList = offerRepository.findAll();
		}
		return offerList;
	}

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
		if (offerRepository.exists(offer.getId())) {
			return null;
		} else {
			return offerRepository.save(offer);
		}
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
	public boolean addOffers(List<Offer> offerList) {
		// TODO Auto-generated method stub
		return false;
	}
}
