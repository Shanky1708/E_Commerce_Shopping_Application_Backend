package com.orderservice.order.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Cart {

    public int cartId;
    public double totalPrice;
    @Autowired
    public List<Items> items;


    public Cart() {
    }
    
    public Cart(int cartId, double totalPrice) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
    }

    public Cart(int cartId, double totalPrice, List<Items> items) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", totalPrice=" + totalPrice + "]";
    }
    
}
