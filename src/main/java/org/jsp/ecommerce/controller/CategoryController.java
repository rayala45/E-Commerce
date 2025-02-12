package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.entity.Category;
import org.jsp.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@PostMapping
	public ResponseEntity<?> saveCategory(@RequestBody Category category){
		return service.saveCategory(category);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCategory(){
		return service.findAllCategory();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCategoryById(@PathVariable int id){
		return service.findCategoryById(id);
	}
	
	@GetMapping("/category/{name}")
	public ResponseEntity<?> findCategoryByName(@PathVariable String name){
		return service.findCategoryByName(name);
	}
	
	@GetMapping("/allProducts/{cid}")
	public ResponseEntity<?> findAllProductsOfCategory(@PathVariable int cid){
		return service.findAllProductsOfCategory(cid);
	}
	
	
	

}
