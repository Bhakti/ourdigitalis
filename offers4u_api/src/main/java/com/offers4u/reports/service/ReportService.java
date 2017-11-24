/**
 * 
 */
package com.offers4u.reports.service;

import java.util.List;

import com.offers4u.common.OfferReport;

/**
 * @author Atul Pradhan
 *
 */
public interface ReportService {

	List<OfferReport> getOffersReports(String merchantName, String fromDate, String toDate);
	
	List<List<String>> getAllCustomerOffersDataList();

}
