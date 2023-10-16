package com.shop.eshoppingzone.productservice.Repository;

import java.util.List;

import com.shop.eshoppingzone.productservice.Entity.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

    public Product findByProductName(String productName);

    public List<Product> findByCategory(String category);

    public List<Product> findByProductType(String productType);

    public Product findByProductId(int productId);

}
