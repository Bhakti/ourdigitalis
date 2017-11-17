package com.offers4u.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.offers4u.mongodb.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByAccountNumber();

}
