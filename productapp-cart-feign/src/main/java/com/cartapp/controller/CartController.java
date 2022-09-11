package com.cartapp.controller;


import com.cartapp.model.Cart;
import com.cartapp.model.Product;
import com.cartapp.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart-api")
public class CartController {
    private ICartService cartService;
    @Autowired
    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/cart/category/{category}")
    List<Product> getByCategory(@PathVariable("category") String category){
        return cartService.getByCategory(category);
    }
    @GetMapping("/cart/productId/{productId}")
    ResponseEntity<Product> getById(@PathVariable("productId") Integer productId){
        Product product = cartService.getById(productId);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/cart/choice/{choice}")
    List<Product> getByChoice(@PathVariable("choice") String choice){
        return cartService.getByChoice(choice);
    }


    List<Product> productList = new ArrayList<>();
    int totalCost;
    Cart cart = new Cart();
    @GetMapping("/cart/add-to-cart/{choice}")
    ResponseEntity<String> addToCart(@PathVariable("choice") Integer productId){
        Product product =cartService.getById(productId);
        double cost = product.getPrice();
        totalCost+=cost;
        productList.add(product);
        cart.setCartId(1);
        cart.setProducts(productList);
        cart.setTotalCost(totalCost);
         return ResponseEntity.ok("Added to cart");
    }
    @GetMapping("/cart/show-cart")
    ResponseEntity<Cart> showCart(){
        return ResponseEntity.ok(cart);
    }
}
