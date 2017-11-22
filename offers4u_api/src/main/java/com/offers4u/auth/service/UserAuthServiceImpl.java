package com.offers4u.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.auth.controller.dto.LoginDetails;
import com.offers4u.customer.service.CustomerService;
import com.offers4u.mongodb.domain.Customer;

@Service("userAuthService")
public class UserAuthServiceImpl implements UserAuthService {

	@Autowired
	private CustomerService customerService;

	@Override
	public String authenticateUser(LoginDetails loginDetails) {
		Customer customer = customerService.getCustomerByCardNumber(loginDetails.getCardNumber());
		if (null != customer && null != customer.getPersonalDetails()
				&& customer.getPersonalDetails().getPassword().equals(loginDetails.getPassword())) {
			return customer.getId();
		}
		return null;
	}

}
