package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.service.CartitemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartItems")
public class CartitemsController {
	
	@Autowired
	private CartitemsService service;
	
	@PostMapping("/{cid}/{pid}")
	public ResponseEntity<?> addingCartItem(@PathVariable int cid,@PathVariable int pid){
		return service.saveCartitem(cid,pid);
	}
	
	@PatchMapping("/{cid}/{quan}")
	public ResponseEntity<?> changingQuantity(@PathVariable int cid,@PathVariable int quan){
		return service.changingQuantity(cid,quan);
	}

}
