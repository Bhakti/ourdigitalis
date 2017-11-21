package com.offers4u.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.offers4u.mongodb.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	@Query(value = "{ 'id' :  { $regex: ?0 } }")
	public Customer findByCustomerId();
	
	@Query(value = "{ 'id' :  { $regex: ?0 } }")
	public Customer findProfileByCustomerId();

	@Query(value = "{ 'recommendedOffers.offer.id' : { $regex: ?0 } }", fields = "{_id : 0}")
	public List<Customer> findCustomerIdByRecommendedOfferId(String offerId);

	@Query(value = "{ 'recommendedOffers.offer.id' : { $regex: ?0 } , 'recommendedOffers.result' : 'Interested' }", fields = "{_id : 0}")
	public List<Customer> findCustomerIdByRecommendedOfferIdInterested(String offerId);

	@Query(value = "{ 'recommendedOffers.offer.id' : { $regex: ?0 } , 'recommendedOffers.result' : 'Availed' }", fields = "{_id : 0}")
	public List<Customer> findCustomerIdByRecommendedOfferIdAvailed(String offerId);

}
