package com.offers4u.reports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.common.OfferReport;
import com.offers4u.reports.service.ReportService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1")
public class ReportsController {

	@Autowired
	private ReportService reportService;

	@RequestMapping(value = "/reports", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<OfferReport> getOffersReports(@RequestParam(name = "merchant", required = false) String merchantName,
			@RequestParam(name = "fromDate", required = false) String fromDate,
			@RequestParam(name = "toDate", required = false) String toDate) {
		return reportService.getOffersReports(merchantName, fromDate, toDate);
	}

	@RequestMapping(value = "/customerfeatures", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<List<String>> getCustomerOffers() {
		return reportService.getAllCustomerOffersDataList();

	}

}