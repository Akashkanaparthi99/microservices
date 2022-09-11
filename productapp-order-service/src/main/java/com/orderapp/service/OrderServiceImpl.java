package com.orderapp.service;

import com.orderapp.model.Cart;
import com.orderapp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements IOrderService{
    private RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String CARTURL = "http://CART-SERVICE/cart-api/cart";
   Order order = new Order();
    @Override
    public Order viewOrder() {
        String url = CARTURL.concat("/show-cart");
        ResponseEntity<Cart> responseEntity = restTemplate.getForEntity(url,Cart.class );
        Cart cart = responseEntity.getBody();
        order.setCart(cart);
        order.setOrderId(1);
        order.setOrderDate(LocalDate.now());
        order.setOrderTotal(cart.getTotalCost());
        order.setPaymentMode("COD");
        order.setCity("Hyderabad");

        return order;
    }


}
