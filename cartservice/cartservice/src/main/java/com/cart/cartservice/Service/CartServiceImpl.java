package com.cart.cartservice.Service;

import java.util.ArrayList;
import java.util.List;

import com.cart.cartservice.Entity.Cart;
import com.cart.cartservice.Entity.Items;
import com.cart.cartservice.Repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    public CartRepository cartRepository;

    public CartServiceImpl() {
    }

    @Override
    public Cart getCartById(int cartId) {
        Cart cart = this.cartRepository.findByCartId(cartId);
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        List<Items> items = new ArrayList<>();
        items.add(new Items(((Items) cart.items).getProductName(), ((Items) cart.items).getPrice(),
                ((Items) cart.items).getQuantity()));
        cart.setCartId(cart.getCartId());
        cart.setTotalPrice(cart.getTotalPrice());
        cart.setItems(items);
        final Cart cart2 = this.cartRepository.save(cart);
        return cart2;
    }

    @Override
    public List<Cart> getAllCarts() {
        List<Cart> c1 = this.cartRepository.findAll();
        return c1;
    }

    @Override
    public double cartTotal(Cart cart) {
        List<Items> items = new ArrayList<>();
        items = cart.getItems();

        double totalPrice = 0;
        for (Items item : items) {
            totalPrice = totalPrice + (item.getPrice() * item.getQuantity());
        }
        return totalPrice;
    }

    @Override
    public String deleteAllCart() {

        this.cartRepository.deleteAll();
        return "Deleted";
    }

    @Override
    public Cart addCart(Cart cart) {
        Cart c1 = this.cartRepository.save(cart);
        return c1;
    }

}
