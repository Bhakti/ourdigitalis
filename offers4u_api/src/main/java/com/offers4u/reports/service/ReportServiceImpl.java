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
			int ageOfCustomer = getAge(customer.getPersonalDetails().getDob());
			List<Category> categoriesOfCustomer = customer.getCategoryPreferences();
			String gender = customer.getPersonalDetails().getGender();
			String incomeRange = customer.getPersonalDetails().getCurrentAnnualIncome();
			List<String> custStringList = getAllInStringFormat(ageOfCustomer, categoriesOfCustomer, gender,
					incomeRange);

			processedCustomers.add(custStringList);
		}
		return processedCustomers;
	}

	private List<String> getAllInStringFormat(int ageOfCustomer, List<Category> categoriesOfCustomer, String gender,
			String incomeRange) {
		List<String> cateString = new ArrayList<>();
		for (Category category : categoriesOfCustomer) {
			cateString.addAll(getCategoriesInEnumFormat(category.getCategoryName()));
		}
		List<String> custStringList = new ArrayList<>();
		custStringList.add(getAgeEnumMapping(ageOfCustomer));
		custStringList.addAll(cateString);
		custStringList.add(getGenderInEnumformat(gender));
		custStringList.add(getIncomeEnumFormat(incomeRange));
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

	List<String> getCategoriesInEnumFormat(String cat) {
		List<String> catStr = new ArrayList<>();
		if ("Travel".equalsIgnoreCase(cat))
			catStr.add("C1");
		else if ("Dining".equalsIgnoreCase(cat))
			catStr.add("C2");
		else if ("Bill Payment".equalsIgnoreCase(cat))
			catStr.add("C3");
		else if ("Grocery".equalsIgnoreCase(cat))
			catStr.add("C4");
		else if ("Entertainment".equalsIgnoreCase(cat))
			catStr.add("C5");
		else if ("Fashion & Accessiories".equalsIgnoreCase(cat))
			catStr.add("C6");
		else if ("Beauty & Health".equalsIgnoreCase(cat))
			catStr.add("C7");
		else if ("Gifting".equalsIgnoreCase(cat))
			catStr.add("C8");
		else if ("Lifestyle".equalsIgnoreCase(cat))
			catStr.add("C9");
		else if ("Electronics".equalsIgnoreCase(cat))
			catStr.add("C10");

		return catStr;
	}

	String getIncomeEnumFormat(String income) {
		String incomeStr = "";
		if (Integer.getInteger(income)!=null && Integer.getInteger(income).intValue() < 18000)
			incomeStr = "I1";
		else if (Integer.getInteger(income)!=null && Integer.getInteger(income).intValue() < 30000)
			incomeStr = "I2";
		else if (Integer.getInteger(income)!=null && Integer.getInteger(income).intValue() < 50000)
			incomeStr = "I3";
		else if (Integer.getInteger(income)!=null && Integer.getInteger(income).intValue() < 50000)
			incomeStr = "I4";
		return incomeStr;
	}
}
