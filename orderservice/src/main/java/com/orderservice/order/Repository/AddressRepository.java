package com.orderservice.order.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.order.Entity.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, Integer> {

    public Address findByCustomerId(int customerId);

}
