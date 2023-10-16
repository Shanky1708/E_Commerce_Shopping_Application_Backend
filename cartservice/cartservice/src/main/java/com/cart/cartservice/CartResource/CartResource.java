package com.cart.cartservice.CartResource;

import java.util.ArrayList;
import java.util.List;

import com.cart.cartservice.Entity.Cart;
import com.cart.cartservice.Entity.Items;
import com.cart.cartservice.Entity.Product;
import com.cart.cartservice.Service.CartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartResource {

    Logger logger = LoggerFactory.getLogger(CartResource.class);

    @Autowired
    public CartService cartService;

    @Autowired
    public RestTemplate restTemplate;

    public CartResource() {
    }

    @GetMapping("/getAllCarts")
    public ResponseEntity<List<Cart>> getAllCarts() {

        try {
            List<Cart> cart = this.cartService.getAllCarts();
            logger.debug("Response {}", cart);
            return new ResponseEntity<List<Cart>>(cart, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Cart>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/addCart/{cartId}")
    public ResponseEntity<Cart> addCart(@PathVariable("cartId") int cartId) throws NullPointerException {

        logger.debug("Request {}", cartId);
        Cart cart = new Cart();
        cart.setCartId(cartId);
        Product product = this.restTemplate.getForObject("http://localhost:7002/product/getProductById/" + cartId,
                Product.class);
        if (product == null) {
            throw new NullPointerException("No Value Present");
        }

        int quantity = 1;
        List<Items> items = new ArrayList<Items>();
        items.add(new Items(product.getProductName(), product.getPrice(), quantity));
        cart.setItems(items);
        double cartTotal = cartService.cartTotal(cart);
        cart.setTotalPrice(cartTotal);
        try {
            Cart c1 = this.cartService.addCart(cart);
            logger.debug("Response {}", c1);
            return new ResponseEntity<Cart>(c1, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getCart/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable("cartId") int cartId) {

        logger.debug("Request {}", cartId);
        try {
            Cart cart = this.cartService.getCartById(cartId);
            logger.debug("Response {}", cart);
            return new ResponseEntity<Cart>(cart, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateCart")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
        logger.debug("Request {}", cart);
        try {
            Cart c1 = this.cartService.updateCart(cart);
            logger.debug("Response {}", c1);
            return new ResponseEntity<Cart>(c1, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.debug("Response {}", HttpStatus.NOT_FOUND);
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {

        String string = this.cartService.deleteAllCart();
        logger.debug("Response {}", string);
        return string;
    }
}
