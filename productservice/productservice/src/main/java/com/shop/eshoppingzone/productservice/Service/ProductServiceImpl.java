package com.cg.eshoppingzone.productservice.Service;

import java.util.List;

import com.cg.eshoppingzone.productservice.Entity.Product;
import com.cg.eshoppingzone.productservice.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    public ProductServiceImpl() {
    }

    @Override
    public void addProducts(Product product) {
        this.productRepository.save(product);

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        Product product = this.productRepository.findByProductId(productId);
        return product;
    }

    @Override
    public Product getProductByName(String productName) {
        Product product = this.productRepository.findByProductName(productName);
        return product;
    }

    @Override
    public Product updateProducts(Product product) {
        product.setProductId(product.getProductId());
        this.productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProductById(int productId) {
        this.productRepository.deleteById(productId);

    }

    @Override
    public List<Product> getProductByCategory(String category) {
        List<Product> products = this.productRepository.findByCategory(category);
        return products;
    }

    @Override
    public List<Product> getProductByType(String productType) {
        List<Product> products = this.productRepository.findByProductType(productType);
        return products;
    }

}
