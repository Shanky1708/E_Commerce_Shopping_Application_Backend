package com.shop.eshoppingzone.productservice.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shop.eshoppingzone.productservice.Entity.Product;
import com.shop.eshoppingzone.productservice.Repository.ProductRepository;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { ProductServiceImplTest.class })
public class ProductServiceImplTest {

    @Mock
    public ProductRepository productRepository;

    @InjectMocks
    public ProductServiceImpl productServiceImpl;

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

        productServiceImpl.addProducts(product);
        verify(productRepository, times(1)).save(product);

    }

    @Test
    @Order(2)
    void testDeleteProductById() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        List<Product> product = new ArrayList<Product>();
        product.add(new Product(1, "xyz", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3));
        int productId = 1;

        productServiceImpl.deleteProductById(productId);
        verify(productRepository, times(1)).deleteById(productId);

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

        when(this.productRepository.findAll()).thenReturn(product);
        assertEquals(1, productServiceImpl.getAllProducts().size());

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
        when(this.productRepository.findByCategory(category)).thenReturn(product);
        assertEquals(product, productServiceImpl.getProductByCategory(category));

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

        when(this.productRepository.findByProductId(productId)).thenReturn(product);
        assertEquals(product, productServiceImpl.getProductById(productId));

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

        when(this.productRepository.findByProductName(productName)).thenReturn(product);
        assertEquals(product, productServiceImpl.getProductByName(productName));

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
        when(this.productRepository.findByProductType(productType)).thenReturn(product);
        assertEquals(product, productServiceImpl.getProductByType(productType));

    }

    @Test
    @Order(8)
    void testUpdateProducts() {

        Map<Integer, Double> m1 = new HashMap<Integer, Double>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        m1.put(1, 123.00);
        m2.put(1, "Nice Product");
        m3.put("xdtr", "tvtw");
        Product product = new Product(1, "xyz", "rxqty", "ttuf", m1, m2, "image.url", 134.00d, "gvuxwi", m3);

        when(this.productRepository.save(product)).thenReturn(product);
        assertEquals(product, productServiceImpl.updateProducts(product));

    }
}
