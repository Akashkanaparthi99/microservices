package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductappCloudLoadbalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappCloudLoadbalancerApplication.class, args);
	}

//
//	@Bean
//	// create our own route - programmatically
//	RouteLocator customRoutes(RouteLocatorBuilder builder){
//		return builder.routes()
//		// create individual route with id, uri , prdicate(path), filters
//				// productservice
//				.route("productService",predicateSpec -> {
//			return predicateSpec.path("/product-api/**").uri("lb://PRODUCT-SERVICE");
//		} )		// cart Service
//				.route("cartService",predicateSpec -> predicateSpec.path("/cart-api/**").uri("lb://CART-SERVICE"))
//				// order service
//				.route("orderService",ps -> ps.path("/order-api/**").uri("lb://ORDER-SERVICE"))
//				.build();
//	}



}
