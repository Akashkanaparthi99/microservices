package com.cartapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.http.RestTemplateTransportClientFactories;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ProductappCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappCartServiceApplication.class, args);
	}

	// Spring Creates an object of restTemplate
	@Bean
	// this helps to choose the microservice running ina particular port that has performance , sped and fault
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
