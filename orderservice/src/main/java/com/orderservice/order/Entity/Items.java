package com.orderservice.order.Entity;

public class Items {

    public String productName;
    public double price;
    public int quantity;
    
    public Items() {
    }

    public Items(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Items [price=" + price + ", productName=" + productName + ", quantity=" + quantity + "]";
    }

    
}
