package com.orderservice.order.Entity;

public class Product1 {

    public int productId;

    public String productName;

    public Product1() {
    }

    public Product1(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + "]";
    }

    
}
