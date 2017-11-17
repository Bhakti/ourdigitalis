package com.offers4u.merchant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers4u.entity.Merchant;
import com.offers4u.repository.MerchantRepository;

@Service("merchantService")
@Transactional
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public List<Merchant> getMerchants() {
		return merchantRepository.findAll();
	}

}
