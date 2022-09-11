package com.orderapp.model;

import com.cartapp.model.Product;
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
