package com.orderapp.model;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Order {
    private Integer orderId;
    private LocalDate orderDate;
    private Cart cart;
    private String city;
    private String paymentMode;
    private double orderTotal;

}
