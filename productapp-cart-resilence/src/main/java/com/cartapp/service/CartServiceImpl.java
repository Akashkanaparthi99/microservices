package com.cartapp.service;

import com.cartapp.model.Cart;
import com.cartapp.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartServiceImpl implements ICartService{
    // make an API call to Product Service
    // Use an object of RestTemplate
    private RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // port , url,responseEntity -> getForEntity , object, getForObject
    private String BASEURL = "http://PRODUCT-SERVICE/product-api/products";
    Cart cart = new Cart();
    List<Product> productList = new ArrayList<>();
    int totalCost;
    // anootate the method for handling
    @CircuitBreaker(name = "CART-SERVICE",fallbackMethod = "fallBackFindByCat")
    @Override
    public List<Product> getByCategory(String category) {
//  localhost:8081/product-api/products/category/stationery
//        String url = BASEURL + "/category/"+category;
        String url = BASEURL.concat("/category/").concat(category);
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        System.out.println(responseEntity.getStatusCode());
        List<Product> products = responseEntity.getBody();

        return products;
    }

    // fallback method
    // has the sae method signature similar to the calling method
    // should have the exception thrown at last parameter
    public List<Product> fallBackFindByCat(String category,RuntimeException e){
        return new ArrayList<>(); // return empty list instead of exception
    }


    /*
    * @author - Akash
    * @param - productId
    * @return -
    *           this method returns the single product that matches
    *           to the given id
    * */
    @CircuitBreaker(name = "CART-SERVICE",fallbackMethod = "fallBackFindByProductId")
    @Override
    public Product getById(Integer productId) {
        String url = BASEURL.concat("/productId/")+productId;
        ResponseEntity<Product> productResponseEntity = restTemplate.getForEntity(url,Product.class);
        return productResponseEntity.getBody();
    }

    public Product fallBackFindByProductId(Integer productId,RuntimeException e){
        return new Product();
    }

    @CircuitBreaker(name = "CART-SERVICE",fallbackMethod = "fallBackFindByChoice")
    @Override
    public List<Product> getByChoice(String choice) {
        String url = BASEURL.concat("/choice/")+choice;
        List<Product> products = restTemplate.getForObject(url, List.class);
        return products;
    }
    public List<Product> fallBackFindByChoice(String choice,RuntimeException e){
        return new ArrayList<>();
    }

    @Override
    public void addToCart(Integer productId) {
        String url = BASEURL.concat("/productId/")+productId;
        ResponseEntity<Product> responseEntity = restTemplate.getForEntity(url,Product.class);
        Product product = responseEntity.getBody();
        double cost = product.getPrice();
        totalCost+=cost;

        productList.add(product);
        cart.setCartId(1);
        cart.setProducts(productList);
        cart.setTotalCost(totalCost);
    }


    @CircuitBreaker(name = "CART-SERVICE",fallbackMethod = "fallBackShowCart")
    @Override
    public Cart showCart() {
        return cart;
    }
    public Cart fallBackShowCart(RuntimeException e){
        return new Cart();
    }
}
