/**
 * 
 */
package com.offers4u.reports.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.common.OfferReport;
import com.offers4u.mongodb.domain.Category;
import com.offers4u.mongodb.domain.CategoryData;
import com.offers4u.mongodb.domain.Customer;
import com.offers4u.mongodb.domain.Offer;
import com.offers4u.mongodb.domain.RecommendedOffer;
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

				List<Customer> lstCustAv = customerRepository
						.findCustomerIdByRecommendedOfferIdAvailed(offer.getOfferId());
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

	@Override
	public List<List<String>> getAllCustomerOffersDataList() {
		List<List<String>> processedCustomers = new ArrayList<List<String>>();

		List<Customer> allCustomers = customerRepository.findAll();

		for (Customer customer : allCustomers) {
			// A
			int ageOfCustomer = getAge(customer.getPersonalDetails().getDob());
			// G
			String gender = customer.getPersonalDetails().getGender();
			// I
			String incomeRange = customer.getPersonalDetails().getCurrentAnnualIncome();

			// Top Prefer
			List<Category> categoriesOfCustomer = customer.getCategoryPreferences();

			List<CategoryData> categoriesData = customer.getCategoryData();

			List<RecommendedOffer> recommendedOffers = customer.getRecommendedOffers();

			List<String> custStringList = getAllInStringFormat(customer.getId(), ageOfCustomer, categoriesOfCustomer,
					gender, incomeRange, recommendedOffers, categoriesData);

			processedCustomers.add(custStringList);
		}
		return processedCustomers;
	}

	private List<String> getAllInStringFormat(String customerId, int ageOfCustomer, List<Category> categoriesOfCustomer,
			String gender, String incomeRange, List<RecommendedOffer> recommendedOffers,
			List<CategoryData> categoriesData) {
		List<String> custStringList = new ArrayList<>();
		// Id
		custStringList.add(customerId);
		// Age
		custStringList.add(getAgeEnumMapping(ageOfCustomer));
		// Gender
		custStringList.add(getGenderInEnumformat(gender));
		// Income
		custStringList.add(getIncomeEnumFormat(incomeRange));

		// last availed category
		String lastAvailed = "";
		// top availed
		String topAvailed = "";
		// top clicked
		String topClicked = "";

		int topAvailedCount = 0;
		int topClickedCount = 0;
		if (categoriesData != null) {
			//
			if (categoriesData.size() > 1) {
				topAvailed = categoriesData.get(0).getCategory().getCategoryName();
				topClicked = categoriesData.get(0).getCategory().getCategoryName();
			}
			//
			for (CategoryData categoryData : categoriesData) {
				if (categoryData.getAvailedCount() <= topAvailedCount) {
					topAvailedCount = categoryData.getAvailedCount();
					topAvailed = categoryData.getCategory().getCategoryName();
				}
				if (categoryData.getClickedCount() <= topClickedCount) {
					topClickedCount = categoryData.getClickedCount();
					topClicked = categoryData.getCategory().getCategoryName();
				}
			}
			topAvailed = getCategoriesInEnumFormat(topAvailed);
			topClicked = getCategoriesInEnumFormat(topClicked);
		}
		custStringList.add(topAvailed);
		custStringList.add(topClicked);

		// top prefer
		String topPreferred = "";
		if (categoriesOfCustomer != null && categoriesOfCustomer.size() > 1) {
			topPreferred = getCategoriesInEnumFormat(categoriesOfCustomer.get(0).getCategoryName());
		}

		// offers selected
		List<String> offersSelected = new ArrayList<>();
		if (recommendedOffers != null) {
			for (RecommendedOffer recommendedOffer : recommendedOffers) {
				if (recommendedOffer.getAvailedDate() != null) {
					offersSelected.add("s " + recommendedOffer.getOffer().getOfferId());
				}
			}
		}
		custStringList.add(topPreferred);
		custStringList.addAll(offersSelected);
		//
		// custStringList.addAll(cateString);
		return custStringList;
	}

	private int getAge(Date ageString) {

		Date dateOfBirth = ageString;

		Calendar today = Calendar.getInstance();

		int currentYear = today.get(Calendar.YEAR);
		int birthYear = dateOfBirth.getYear();

		int age = currentYear - birthYear;

		return age;
	}

	String getAgeEnumMapping(int age1) {
		String age = "";
		if (age1 > 18 && age1 < 25)
			age = "A1";
		else if (age1 >= 25 && age1 < 40)
			age = "A2";
		else if (age1 >= 40 && age1 < 60)
			age = "A3";
		else
			age = "A4";
		return age;

	}

	String getGenderInEnumformat(String genderString) {
		String genderString1 = "";
		if ("Male".equalsIgnoreCase(genderString))
			genderString1 = "G1";
		else if ("Female".equalsIgnoreCase(genderString))
			genderString1 = "G2";
		return genderString1;
	}

	String getCategoriesInEnumFormat(String cat) {
		String catStr = "";
		if ("Travel".equalsIgnoreCase(cat))
			catStr = "C1";
		else if ("Dining".equalsIgnoreCase(cat))
			catStr = "C2";
		else if ("Bill Payment".equalsIgnoreCase(cat))
			catStr = "C3";
		else if ("Grocery".equalsIgnoreCase(cat))
			catStr = "C4";
		else if ("Entertainment".equalsIgnoreCase(cat))
			catStr = "C5";
		else if ("Fashion & Accessiories".equalsIgnoreCase(cat))
			catStr = "C6";
		else if ("Beauty & Health".equalsIgnoreCase(cat))
			catStr = "C7";
		else if ("Gifting".equalsIgnoreCase(cat))
			catStr = "C8";
		else if ("Lifestyle".equalsIgnoreCase(cat))
			catStr = "C9";
		else if ("Electronics".equalsIgnoreCase(cat))
			catStr = "C10";
		return catStr;
	}

	String getIncomeEnumFormat(String income) {
		String incomeStr = "";
		if (Integer.getInteger(income) != null && Integer.getInteger(income).intValue() < 18000)
			incomeStr = "I1";
		else if (Integer.getInteger(income) != null && Integer.getInteger(income).intValue() < 30000)
			incomeStr = "I2";
		else if (Integer.getInteger(income) != null && Integer.getInteger(income).intValue() < 50000)
			incomeStr = "I3";
		else if (Integer.getInteger(income) != null && Integer.getInteger(income).intValue() < 50000)
			incomeStr = "I4";
		return incomeStr;
	}
}
