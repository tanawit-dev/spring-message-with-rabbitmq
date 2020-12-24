package com.tanawit.customerservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.tanawit.customerservice.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
