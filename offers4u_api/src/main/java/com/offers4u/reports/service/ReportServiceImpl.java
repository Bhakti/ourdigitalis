/**
 * 
 */
package com.offers4u.reports.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.common.OfferReport;
import com.offers4u.mongodb.domain.Customer;
import com.offers4u.mongodb.domain.Offer;
import com.offers4u.mongodb.repository.CustomerRepository;
import com.offers4u.mongodb.repository.OfferRepository;

/**
 * @author Atul Pradhan
 *
 */
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<OfferReport> getOffersReports(String merchantName, String fromDate, String toDate) {
		List<OfferReport> offerReports = new ArrayList<>();
		List<Offer> offers = new ArrayList<>();

		if (merchantName != null) {
			offers = offerRepository.findByMerchantName(merchantName);
		} else {
			offers = offerRepository.findAll();
		}

		
		if (offers != null) {
			for (Offer offer : offers) {
				OfferReport offerReport = new OfferReport();
				int totalRollOuts = 0;
				int totalInterested = 0;
				int totalAvailed = 0;

				offerReport.setOffer(offer);
				List<Customer> lstCust = customerRepository.findCustomerIdByRecommendedOfferId(offer.getOfferId());
				if (lstCust != null) {
					totalRollOuts = lstCust.size();
				}

				List<Customer> lstCustIn = customerRepository
						.findCustomerIdByRecommendedOfferIdInterested(offer.getOfferId());
				if (lstCustIn != null) {
					totalInterested = lstCustIn.size();
				}

				List<Customer> lstCustAv = customerRepository.findCustomerIdByRecommendedOfferIdAvailed(offer.getOfferId());
				if (lstCustAv != null) {
					totalAvailed = lstCustAv.size();
				}

				offerReport.setTotalAvailed(totalAvailed);
				offerReport.setTotalInterested(totalInterested);
				offerReport.setTotalRollOuts(totalRollOuts);
				//
				offerReports.add(offerReport);
				//
			}
		}
		System.out.println(offerReports.toString());
		return offerReports;
	}

}
