package com.orderservice.order.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.order.Entity.Orders;

@Repository
public interface OrderRepository extends MongoRepository<Orders,Integer>{

    public List<Orders> findByCustomerId(int customerId);

    public Orders findFirstByOrderByOrderId();

    public Orders findOrderByOrderId(int orderId);
    
}
