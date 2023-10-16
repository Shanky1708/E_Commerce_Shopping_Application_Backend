package com.shop.eshoppingzone.productservice.Resource;

import java.util.List;

import com.shop.eshoppingzone.productservice.Entity.Product;
import com.shop.eshoppingzone.productservice.Service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductResource {

    Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    public ProductService productService;

    public ProductResource() {
    }

    @PostMapping("/addProducts")
    public ResponseEntity<?> addProducts(@RequestBody Product product) {

        logger.debug("Request {}", product);
        try {
            this.productService.addProducts(product);
            logger.debug("Response {}", HttpStatus.FOUND);
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {

        try {
            List<Product> products = this.productService.getAllProducts();
            logger.debug("Request {}", products);
            return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") int productId) {

        logger.debug("Request {}", productId);
        try {
            Product product = this.productService.getProductById(productId);
            logger.debug("Response {}", product);
            return new ResponseEntity<Product>(product, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getProductByType/{productType}")
    public ResponseEntity<List<Product>> getProductByType(@PathVariable("productType") String productType) {

        logger.debug("Request {}", productType);
        try {
            List<Product> product = this.productService.getProductByType(productType);
            logger.debug("Response {}", product);
            return new ResponseEntity<List<Product>>(product, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getProductByName/{productName}")
    public ResponseEntity<Product> getProductByName(@PathVariable("productName") String productName) {

        logger.debug("Request {}", productName);
        try {
            Product product = this.productService.getProductByName(productName);
            logger.debug("Response {}", product);
            return new ResponseEntity<Product>(product, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getProductByCategory/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category) {

        logger.debug("Request {}", category);
        try {
            List<Product> products = this.productService.getProductByCategory(category);
            logger.debug("Response {}", products);
            return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        logger.debug("Request {}", product);
        try {
            Product product2 = this.productService.updateProducts(product);
            logger.debug("Response {}", product2);
            return new ResponseEntity<Product>(product2, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") int productId) {
        logger.debug("Request {}", productId);
        try {
            this.productService.deleteProductById(productId);
            logger.debug("Response {}", HttpStatus.FOUND);
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
