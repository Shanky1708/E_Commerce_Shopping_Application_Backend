package com.orderservice.order.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Orders {

    @Id
    public int orderId;
    public String orderDate;
    public int customerId;
    public Double amountPaid;
    public String modeOfPayment;
    public String orderStatus;
    public int quantity;

    public Address address;
    public Product1 product;

    public Orders() {
    }

    public Orders(int orderId, String orderDate, int customerId, Double amountPaid, String modeOfPayment,
            String orderStatus, int quantity, Address address, Product1 product) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.amountPaid = amountPaid;
        this.modeOfPayment = modeOfPayment;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
        this.address = address;
        this.product = product;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Product1 getProduct() {
        return product;
    }

    public void setProduct(Product1 product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Orders [address=" + address + ", amountPaid=" + amountPaid + ", customerId=" + customerId
                + ", modeOfPayment=" + modeOfPayment + ", orderDate=" + orderDate + ", orderId=" + orderId
                + ", orderStatus=" + orderStatus + ", product=" + product + ", quantity=" + quantity + "]";
    }

}
