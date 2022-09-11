package com.cartapp.service;

import com.cartapp.model.Cart;
import com.cartapp.model.Product;

import java.util.List;

public interface ICartService {
    List<Product> getByCategory(String category);
    Product getById(Integer productId);
    List<Product> getByChoice(String choice);

    void addToCart(Integer productId);
    Cart showCart();
}
