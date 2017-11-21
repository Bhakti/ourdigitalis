package com.offers4u.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.offers4u.mongodb.domain.Offer;

@Repository
public interface OfferRepository extends MongoRepository<Offer, String> {

	@Query(value = "{ 'name' :  ?0  }", fields = "{}")
	public List<Offer> findByName(String name);

	@Query(value = "{ 'offerType' : ?0  }", fields = "{}")
	public List<Offer> findByOfferType(String offerType);

	@Query(value = "{ 'category.id' : ?0  }", fields = "{}")
	public List<Offer> findByCategoryId(String categoryId);

	@Query(value = "{ 'merchant.id'  :  ?0  }", fields = "{}")
	public List<Offer> findByMerchantId(String merchantId);

	@Query(value = "{ 'segment.id'  :  ?0  }", fields = "{}")
	public List<Offer> findBySegmentId(String segmentId);

	@Query(value = "{ 'category.categoryName' : ?0 }", fields = "{}")
	public List<Offer> findByCategoryName(String categoryName);

	@Query("{ 'merchant.merchantName' :  ?0  }")
	public List<Offer> findByMerchantName(String merchantName);

	@Query("{ 'segment.segmentName' :  ?0  }")
	public List<Offer> findBySegmentName(String segmentName);

	@Query(value = "{ 'category.categoryName' : { $regex: ?0 } }", fields = "{}")
	public List<Offer> findByCategoryNameLike(String categoryName);

	@Query("{ 'merchant.merchantName' :  { $regex: ?0 } }")
	public List<Offer> findByMerchantNameLike(String merchantName);

	@Query("{ 'category.categoryName' :  { $regex: ?0 }, 'merchant.merchantName' : { $regex: ?0 } }")
	public List<Offer> findByCategoryNameMerchantNameLike(String categoryName, String merchantName);

}