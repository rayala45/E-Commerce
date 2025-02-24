package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService service;
	
	@GetMapping("/{uid}")
	public ResponseEntity<?> viewCart(@PathVariable int uid){
		return service.viewCart(uid);
	}
	@GetMapping("/cartItems/{cid}")
	public ResponseEntity<?> viewCartItems(@PathVariable int cid){
		return service.viewCartItems(cid);
	}
	
	
	

}
