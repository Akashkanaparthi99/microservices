package com.cartapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Column(name = "productid")
    @Id
    @GeneratedValue(generator = "product_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen", sequenceName = "product_sequence", initialValue = 100, allocationSize = 1)
    private Integer productId;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String category;
    @Column(length = 20)
    private String brand;
    @Column(length = 20)
    private double price;

    public Product(String name, String category, String brand, double price) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
    }
}
