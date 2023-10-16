package com.cart.cartservice.CartResource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.cart.cartservice.Entity.Cart;
import com.cart.cartservice.Entity.Items;
import com.cart.cartservice.Service.CartService;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { CartResourceTest.class })
public class CartResourceTest {

    @Mock
    public CartService cartService;

    @InjectMocks
    public CartResource cartResource;

    @Test
    @Order(1)
    void testGetAllCarts() {

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("Facewash", 123.00, 1));
        List<Cart> cart = new ArrayList<Cart>();
        cart.add(new Cart(1, 123.00, items));

        when(this.cartService.getAllCarts()).thenReturn(cart);
        ResponseEntity<List<Cart>> responseEntity = cartResource.getAllCarts();
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(2)
    void testGetCart() {

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("Facewash", 123.00, 1));
        Cart cart = new Cart(1, 123.00, items);
        int cartId = 1;

        when(this.cartService.getCartById(cartId)).thenReturn(cart);
        ResponseEntity<Cart> responseEntity = cartResource.getCart(cartId);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(3)
    void testUpdateCart() {

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("Facewash", 123.00, 1));
        Cart cart = new Cart(1, 123.00, items);

        when(this.cartService.updateCart(cart)).thenReturn(cart);
        ResponseEntity<Cart> responseEntity = cartResource.updateCart(cart);
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

    }

    @Test
    @Order(4)
    void testdeleteAll() {

        String string = "Deleted";
        when(this.cartService.deleteAllCart()).thenReturn(string);
        assertEquals(string, cartResource.deleteAll());

    }

}
