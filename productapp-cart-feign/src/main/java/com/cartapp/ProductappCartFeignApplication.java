package com.cartapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProductappCartFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappCartFeignApplication.class, args);
	}

}
