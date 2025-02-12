package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.entity.Product;
import org.jsp.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllProducts(){
		return service.findAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findProductById(@PathVariable int id){
		return service.findProductById(id);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findAllProductsByName(@PathVariable String name){
		return service.findAllProductsByName(name);
	}
	
	@GetMapping("/price/{price}")
	public ResponseEntity<?> filterProductsByRange(@PathVariable int price){
		return service.filterProductsByRange(price);
	}
	
	@GetMapping("/range/{Lprice}/{Hprice}")
	public ResponseEntity<?> filterProductsByPriceRange(@PathVariable int Lprice,@PathVariable int Hprice){
		return service.filterProductsByPriceRange(Lprice,Hprice);
	}
	
	@GetMapping("/Category/{id}")
	public ResponseEntity<?> findAllProductsByCategory(@PathVariable int id){
		return service.findAllProductsByCategory(id);
	}
	
	@GetMapping("/CategoryName/{name}")
	public ResponseEntity<?> findAllProductsByCategoryName(@PathVariable String name){
		return service.findAllProductsByCategoryName(name);
	}
	
	@GetMapping("/searchByname/{name}")
	public ResponseEntity<?> searchProductsByName(@PathVariable String name){
		return service.searchProductsByName(name);
	}

}
