package com.offers4u.merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.mongodb.domain.Merchant;
import com.offers4u.mongodb.repository.MerchantRepository;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public List<Merchant> getMerchants() {
		return merchantRepository.findAll();
	}

}
