package com.offers4u.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offers4u.mysql.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
