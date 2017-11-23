package com.offers4u.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.offers4u.mongodb.domain.Offer;

@Repository
public interface OfferRepository extends MongoRepository<Offer, String> {

	
	@Query(value = "{ 'offerId' :  ?0  }", fields = "{}")
	public Offer findByOfferId(String offerId);
	
	@Query(value = "{ 'offerType' : ?0  }", fields = "{}")
	public List<Offer> findByOfferType(String offerType);

	@Query(value = "{ 'category.categoryName' : ?0 }", fields = "{}")
	public List<Offer> findByCategoryName(String categoryName);

	@Query("{ 'merchant.merchantName' :  ?0  }")
	public List<Offer> findByMerchantName(String merchantName);

	@Query(value = "{ 'category.categoryName' : { $regex: ?0 } }", fields = "{}")
	public List<Offer> findByCategoryNameLike(String categoryName);

	@Query("{ 'merchant.merchantName' :  { $regex: ?0 } }")
	public List<Offer> findByMerchantNameLike(String merchantName);

	@Query("{ 'category.categoryName' :  { $regex: ?0 }, 'merchant.merchantName' : { $regex: ?0 } }")
	public List<Offer> findByCategoryNameMerchantNameLike(String categoryName, String merchantName);

}