package com.shop.eshoppingzone.productservice.Entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

    @Id
    private int productId;
    private String productType;
    private String productName;
    private String category;
    private Map<Integer, Double> rating;
    private Map<Integer, String> review;
    private String image;
    private double price;
    private String description;
    private Map<String, String> specification;

    public Product() {
    }

    public Product(int productId, String productType, String productName, String category, Map<Integer, Double> rating,
            Map<Integer, String> review, String image, double price, String description,
            Map<String, String> specification) {
        this.productId = productId;
        this.productType = productType;
        this.productName = productName;
        this.category = category;
        this.rating = rating;
        this.review = review;
        this.image = image;
        this.price = price;
        this.description = description;
        this.specification = specification;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Map<Integer, Double> getRating() {
        return rating;
    }

    public void setRating(Map<Integer, Double> rating) {
        this.rating = rating;
    }

    public Map<Integer, String> getReview() {
        return review;
    }

    public void setReview(Map<Integer, String> review) {
        this.review = review;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getSpecification() {
        return specification;
    }

    public void setSpecification(Map<String, String> specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Product [category=" + category + ", description=" + description + ", image=" + image + ", price="
                + price + ", productId=" + productId + ", productName=" + productName + ", productType=" + productType
                + ", rating=" + rating + ", review=" + review + ", specification=" + specification + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + productId;
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
        Product other = (Product) obj;
        if (productId != other.productId)
            return false;
        return true;
    }

}
