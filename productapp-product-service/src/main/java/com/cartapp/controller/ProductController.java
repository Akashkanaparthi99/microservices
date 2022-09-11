package com.cartapp.controller;


import com.cartapp.exception.ProductNotFoundException;
import com.cartapp.model.Product;
import com.cartapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Profile("prod")
@RestController
@RequestMapping("/product-api")
public class ProductController {

	private IProductService productService;
	private String message;
	@Value("${message}")
	public void setMessage(String message) {
		this.message = message;
	}

	@GetMapping("/greet")
	public String greet(){
		return message;
	}

	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/products")
	public ResponseEntity<Void> addProduct(@RequestBody Product product){
		productService.addProduct(product);
		ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
		return responseEntity;
	}
	@PutMapping("/products")
	public ResponseEntity<Void> updateProduct(@RequestBody Product product){
		productService.updateProduct(product);
		ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
		return responseEntity;
	}

	@DeleteMapping("/products/productId/{productid}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productid")int productId){
		productService.deleteProduct(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","deleting one product by Id");
		ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.OK).build();
		return responseEntity;
	}

	@GetMapping("/products/productId/{productId}")
	ResponseEntity<Product> getById(@PathVariable("productId") int productId){
		Product product = productService.getById(productId);
		ResponseEntity<Product> responseEntity = ResponseEntity.ok().body(product);
		return responseEntity;
	}


	@GetMapping("/products")
	ResponseEntity<List<Product>> getAll(){
		List<Product> products = productService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","getting all products");
		headers.add("info","get all Method called");
		ResponseEntity<List<Product>> productResponse = new ResponseEntity<>(products,headers, HttpStatus.OK);
		return productResponse;
	}

	@GetMapping("/products/category/{category}")
	ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category) throws ProductNotFoundException{
		List<Product> products = productService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by Category"+category);
		return ResponseEntity.ok().headers(headers).body(products);

	}
	@GetMapping("/products/brand/{brand}")
	ResponseEntity<List<Product>> getByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException{
		List<Product> products = productService.getByBrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by brand"+brand);
		return ResponseEntity.ok().headers(headers).body(products);

	}
	@GetMapping("/products/price/{price}")
	ResponseEntity<List<Product>> getByLesserPrice(@PathVariable("price") double price) throws ProductNotFoundException{
		List<Product> products = productService.getByLesserPrice(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by lesser price"+price);
		return ResponseEntity.ok().headers(headers).body(products);

	}
	@GetMapping("/products/brandStart/{brand}")
	ResponseEntity<List<Product>> getByBrandStarting(@PathVariable("brand")String brand) throws ProductNotFoundException{
		System.out.println(brand);
		List<Product> products = productService.getByBrandStarting(brand);
		ResponseEntity<List<Product>> productResponse = ResponseEntity.ok().body(products);
		return productResponse;
	}
	@GetMapping("/products/choice/{choice}")
	List<Product> getByChoice(@PathVariable("choice") String choice){
		List<Product> products = productService.getByChoice(choice);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","Get by choice"+choice);
		return products;
	}

}
