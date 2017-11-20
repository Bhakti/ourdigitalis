package com.offers4u.mysql.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.offers4u.mysql.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {

	@Query("select offer from Offer offer where offer.category.categoryId=:categoryId")
	List<Offer> getOffersByCategory(String categoryId);

	@Query("select offer from Offer offer where offer.merchant.merchantId=:merchantd")
	List<Offer> getOffersByMerchant(String merchantId);

	@Query("select offer from Offer offer where offer.category.categoryId=:categoryId and offer.merchant.merchantId=:merchantd")
	List<Offer> getOffersByCategoryAndMerchant(String categoryId, String merchantId);

	@Query("select offer from Offer offer where offer.category.categoryId=:categoryId and offer.merchant.merchantId=:merchantd")
	List<Offer> getOffersByParams(String categoryId, String merchantId, Date fromDate, Date toDate);

}
