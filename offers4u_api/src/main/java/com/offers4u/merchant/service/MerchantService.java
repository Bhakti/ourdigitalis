package com.offers4u.merchant.service;

import java.util.List;

import com.offers4u.mongodb.domain.Merchant;



public interface MerchantService {

	List<Merchant> getMerchants();
}
