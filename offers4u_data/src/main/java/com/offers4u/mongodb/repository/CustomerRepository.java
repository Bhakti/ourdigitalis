package com.offers4u.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.offers4u.mongodb.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	@Query(value = "{ 'id' :  ?0  }")
	public Customer findByCustomerId(String customerId);

	@Query(value = "{ 'cardNumber' :  ?0  }")
	public Customer findByCardNumber(String cardNumber);
	
	@Query(value = "{ 'recommendedOffers.offer.offerId' : ?0}", fields = "{_id : 0}")
	public List<Customer> findCustomerIdByRecommendedOfferId(String offerId);

	@Query(value = "{ 'recommendedOffers.offer.offerId' : ?0, 'recommendedOffers.result' : 'clicked' }", fields = "{_id : 0}")
	public List<Customer> findCustomerIdByRecommendedOfferIdInterested(String offerId);

	@Query(value = "{ 'recommendedOffers.offer.offerId' : ?0, 'recommendedOffers.result' : 'availed' }", fields = "{_id : 0}")
	public List<Customer> findCustomerIdByRecommendedOfferIdAvailed(String offerId);
	
}
