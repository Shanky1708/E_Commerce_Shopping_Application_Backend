package com.cart.cartservice.Service;

import java.util.List;

import com.cart.cartservice.Entity.Cart;

public interface CartService {

    public Cart getCartById(int cartId);

    public Cart updateCart(Cart cart);

    public List<Cart> getAllCarts();

    public double cartTotal(Cart cart);

    public Cart addCart(Cart cart);

    public String deleteAllCart();

}
