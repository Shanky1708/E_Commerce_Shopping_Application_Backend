package com.orderservice.order.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.order.Entity.Address;
import com.orderservice.order.Entity.Orders;
import com.orderservice.order.Repository.AddressRepository;
import com.orderservice.order.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

   public int orderId;

   public int customerId;

   @Autowired
   public OrderRepository orderRepository;

   @Autowired
   public AddressRepository addressRepository;

   public OrderServiceImpl() {
   }

   @Override
   public List<Orders> getAllOrders() {
      List<Orders> orders = this.orderRepository.findAll();
      return orders;

   }

   @Override
   public void placeOrder(Orders order) {
      this.orderRepository.save(order);

   }

   @Override
   public void changeStatus(String orderStatus, int orderId) {
      Orders order = this.orderRepository.findOrderByOrderId(orderId);
      order.setOrderStatus(orderStatus);
      this.orderRepository.save(order);

   }

   @Override
   public void deleteOrder(int orderId) {
      this.orderRepository.deleteById(orderId);

   }

   @Override
   public List<Orders> getOrderByCustomerId(int customerId) {
      List<Orders> orders = this.orderRepository.findByCustomerId(customerId);
      return orders;
   }

   @Override
   public void storeAddress(Address address) {
      this.addressRepository.save(address);

   }

   @Override
   public Address getAddressByCustomerId(int customerId) {
      Address address = this.addressRepository.findByCustomerId(customerId);
      return address;
   }

   @Override
   public List<Address> getAllAddress() {
      List<Address> address = this.addressRepository.findAll();
      return address;
   }

   @Override
   public Orders getOrderById(int orderId) {
      Orders orders = this.orderRepository.findOrderByOrderId(orderId);
      return orders;
   }

   @Override
   public void deleteAddressByCustomerId(int customerId) {
      this.addressRepository.deleteById(customerId);

   }

}
