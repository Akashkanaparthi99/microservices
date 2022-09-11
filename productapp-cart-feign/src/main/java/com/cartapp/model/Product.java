package com.cartapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private Integer productId;
    private String name;
    private String category;
    private String brand;
    private double price;

    public Product(String name, String category, String brand, double price) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
    }
}
