package com.cart.cartservice.Repository;

import com.cart.cartservice.Entity.Cart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer> {

    public Cart findByCartId(int cartId);

}
