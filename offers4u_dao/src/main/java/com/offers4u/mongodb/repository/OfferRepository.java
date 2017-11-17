package com.offers4u.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.offers4u.mongodb.domain.Offer;

@Repository
public interface OfferRepository extends MongoRepository<Offer, String> {

}
