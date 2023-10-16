package com.cart.cartservice.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.cart.cartservice.Entity.Cart;
import com.cart.cartservice.Entity.Items;
import com.cart.cartservice.Repository.CartRepository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { CartServiceImplTest.class })
public class CartServiceImplTest {

    @Mock
    public CartRepository cartRepository;

    @InjectMocks
    public CartServiceImpl cartServiceImpl;

    @Test
    @Order(1)
    void testAddCart() {

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("Facewash", 123.00d, 1));

        Cart cart = new Cart();
        cart.setCartId(10);
        cart.setTotalPrice(123.00);
        cart.setItems(items);

        when(this.cartRepository.save(cart)).thenReturn(cart);
        assertEquals(cart, cartServiceImpl.addCart(cart));

    }

    @Test
    @Order(2)
    void testGetAllCarts() {

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("Facewash", 123.00d, 1));

        List<Cart> cart = new ArrayList<Cart>();
        cart.add(new Cart(10, 123.00d, items));

        when(this.cartRepository.findAll()).thenReturn(cart);
        assertEquals(cart, cartServiceImpl.getAllCarts());

    }

    @Test
    @Order(3)
    void testGetCartById() {

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("Facewash", 123.00d, 1));

        Cart cart = new Cart();
        cart.setCartId(10);
        cart.setTotalPrice(123.00);
        cart.setItems(items);

        when(this.cartRepository.findByCartId(cart.getCartId())).thenReturn(cart);
        assertEquals(cart, cartServiceImpl.getCartById(cart.getCartId()));

    }

    @Test
    @Order(4)
    void testUpdateCart() {

        List<Items> items = new ArrayList<Items>();
        items.add(new Items("Facewash", 123.00d, 1));

        Cart cart = new Cart();
        cart.setCartId(10);
        cart.setTotalPrice(123.00);
        cart.setItems(items);

        when(cartRepository.save(cart)).thenReturn(cart);
        assertEquals(cart, this.cartRepository.save(cart));
    }

    @Test
    @Order(5)
    void testdeleteAllCart() {

        cartServiceImpl.deleteAllCart();
        verify(cartRepository, times(1)).deleteAll();

    }

}
