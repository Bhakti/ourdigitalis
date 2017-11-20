package com.offers4u.offers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.mongodb.domain.Offer;
import com.offers4u.offers.service.OffersService;

@RestController
@RequestMapping(path = "/offers")
public class OfferController {

	@Autowired
	private OffersService offersService;

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<Offer> getOffersByParams(@RequestParam(name = "category", required = false) String categoryName,
			@RequestParam(name = "merchant", required = false) String merchantName,
			@RequestParam(name = "fromDate", required = false) String fromDate,
			@RequestParam(name = "toDate", required = false) String toDate) {
		return offersService.getOffers(categoryName, merchantName, fromDate, toDate);
	}

	@RequestMapping(value = "/{offerId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Offer getOffers(@PathVariable("offerId") String offerId) {
		return offersService.getOffer(offerId);
	}

}