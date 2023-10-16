package com.shop.eshoppingzone.productservice.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shop.eshoppingzone.productservice.Entity.Product;
import com.shop.eshoppingzone.productservice.Service.ProductService;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { ProductResourceTest.class })
public class ProductResourceTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductResource productResource;

    @Test
    @Order(1)
    void testAddProducts() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        Product product = new Product(1, "xyz", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3);

        productResource.addProducts(product);
        ResponseEntity<?> responseEntity = productResource.addProducts(product);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(2)
    void testDeleteProduct() {

        int productId = 1;
        productResource.deleteProduct(productId);
        ResponseEntity<?> responseEntity = productResource.deleteProduct(productId);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
    }

    @Test
    @Order(3)
    void testGetAllProducts() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        List<Product> product = new ArrayList<Product>();
        product.add(new Product(1, "xyz", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3));

        when(this.productService.getAllProducts()).thenReturn(product);
        ResponseEntity<List<Product>> responseEntity = productResource.getAllProducts();
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(4)
    void testGetProductByCategory() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        String category = "ttuf";
        List<Product> product = new ArrayList<Product>();
        product.add(new Product(1, "xyz", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3));
        when(this.productService.getProductByCategory(category)).thenReturn(product);
        ResponseEntity<List<Product>> responseEntity = productResource.getProductByCategory(category);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(5)
    void testGetProductById() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        int productId = 1;
        Product product = new Product(1, "xyz", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3);

        when(this.productService.getProductById(productId)).thenReturn(product);
        ResponseEntity<Product> responseEntity = this.productResource.getProductById(productId);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(6)
    void testGetProductByName() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        String productName = "rxqty";
        Product product = new Product(1, "xyz", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3);

        when(this.productService.getProductByName(productName)).thenReturn(product);
        ResponseEntity<Product> responseEntity = this.productResource.getProductByName(productName);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(7)
    void testGetProductByType() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        String productType = "xyz";
        List<Product> product = new ArrayList<Product>();
        product.add(new Product(1, "xyz", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3));
        when(this.productService.getProductByType(productType)).thenReturn(product);
        ResponseEntity<List<Product>> responseEntity = productResource.getProductByType(productType);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(8)
    void testUpdateProduct() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        Product product = new Product(1, "abc", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3);

        when(this.productService.updateProducts(product)).thenReturn(product);
        ResponseEntity<Product> responseEntity = this.productResource.updateProduct(product);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }
}
