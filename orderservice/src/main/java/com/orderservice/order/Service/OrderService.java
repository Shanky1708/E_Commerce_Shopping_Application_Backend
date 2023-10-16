package com.orderservice.order.Service;

import java.util.List;

import com.orderservice.order.Entity.Address;
import com.orderservice.order.Entity.Orders;

public interface OrderService {

    public List<Orders> getAllOrders();

    public void placeOrder(Orders order);

    public void changeStatus(String orderStatus, int orderId);

    public void deleteOrder(int orderId);

    public List<Orders> getOrderByCustomerId(int customerId);

    public void storeAddress(Address address);

    public Address getAddressByCustomerId(int customerId);

    public List<Address> getAllAddress();

    public Orders getOrderById(int orderId);

    public void deleteAddressByCustomerId(int customerId);

}
