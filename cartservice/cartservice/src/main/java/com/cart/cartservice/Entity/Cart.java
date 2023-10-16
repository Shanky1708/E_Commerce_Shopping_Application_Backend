package com.cart.cartservice.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class Cart {

    @Id
    public int cartId;
    public double totalPrice;

    public List<Items> items;

    public Cart() {
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public Cart(int cartId, List<Items> items) {
        this.cartId = cartId;
        this.items = items;
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

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", totalPrice=" + totalPrice + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cartId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (cartId != other.cartId)
            return false;
        return true;
    }

}
