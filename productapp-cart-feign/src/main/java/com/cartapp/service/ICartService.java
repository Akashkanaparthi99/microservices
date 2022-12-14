package com.cartapp.service;

import com.cartapp.model.Cart;
import com.cartapp.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
// cart-service is the client for mobile-service
// give the name of the service to which you want to connect
// This is a proxy interface.
// The implementation class will be generated by feign during the runtime

@FeignClient(name = "PRODUCT-SERVICE")
public interface ICartService {
    @GetMapping("/product-api/products/category/{category}")
    List<Product> getByCategory(@PathVariable("category") String category);

    @GetMapping("/product-api/products/productId/{productId}")
    Product getById(@PathVariable("productId") Integer productId);

    @GetMapping("/product-api/products/choice/{choice}")
    List<Product> getByChoice(@PathVariable("choice") String choice);
}