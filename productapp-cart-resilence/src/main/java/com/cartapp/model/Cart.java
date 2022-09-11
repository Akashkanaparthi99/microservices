package com.cartapp.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart {
    Integer cartId;
    List<Product> products;
    double totalCost;
}
