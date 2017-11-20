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
	public List<Offer> getOffers(String categoryName, String merchantName, String fromDate, String toDate) {
		// TO DO date -- to filter expired offers. ongoing and future can be shown.
		// add pagination..
		List<Offer> offerList = new ArrayList<>();
		if (categoryName != null && !categoryName.trim().isEmpty() && merchantName != null
				&& !merchantName.trim().isEmpty()) {
			offerList = offerRepository.findByCategoryNameMerchantNameLike(categoryName, merchantName);
		} else if (categoryName != null && !categoryName.trim().isEmpty()) {
			offerList = offerRepository.findByCategoryNameLike(categoryName);

		} else if (merchantName != null && !merchantName.trim().isEmpty()) {
			offerList = offerRepository.findByMerchantNameLike(merchantName);
		} else {
			offerList = offerRepository.findAll();
		}

		return offerList;
	}

	@Override
	public Offer getOffer(String offerId) {
		return offerRepository.findOne(offerId);
	}

	@Override
	public List<Offer> getOffersByCategoryName(String categoryName) {
		return offerRepository.findByCategoryName(categoryName);
	}

	@Override
	public List<Offer> getOffersByMerchantName(String merchantName) {
		return offerRepository.findByMerchantName(merchantName);
	}

	@Override
	public List<Offer> getOffersBySegmentName(String segmentName) {
		return offerRepository.findBySegmentName(segmentName);
	}

	@Override
	public Offer addOffer(Offer offer) {
		if (!offerRepository.exists(offer.getId())) {
			return offerRepository.save(offer);
		}
		return null;
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
