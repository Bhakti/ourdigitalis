package com.offers4u.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offers4u.merchant.service.MerchantService;
import com.offers4u.mongodb.domain.Merchant;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/merchants")
public class MerchantController {

	@Autowired
	private MerchantService merchantService;

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<Merchant> getMerchants() {
		return merchantService.getMerchants();
	}
	
}