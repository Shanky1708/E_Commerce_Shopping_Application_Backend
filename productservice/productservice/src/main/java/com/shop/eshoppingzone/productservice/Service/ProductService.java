package com.cg.eshoppingzone.productservice.Service;

import java.util.List;

import com.cg.eshoppingzone.productservice.Entity.Product;

public interface ProductService {

    public void addProducts(Product product);

    public List<Product> getAllProducts();

    Product getProductById(int productId);

    Product getProductByName(String productName);

    public Product updateProducts(Product product);

    public void deleteProductById(int productId);

    public List<Product> getProductByCategory(String category);

    public List<Product> getProductByType(String productType);
}
