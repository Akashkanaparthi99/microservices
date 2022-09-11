package com.orderapp.controller;

import com.orderapp.model.Order;
import com.orderapp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-api")
public class OrderController {
    private IOrderService orderService;
    @Autowired
    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/order/view-order")
    public ResponseEntity<Order> viewOrder(){
        Order order = orderService.viewOrder();
        return ResponseEntity.ok(order);
    }
}
