package org.jsp.ecommerce.service;

import org.springframework.http.ResponseEntity;

public interface CartService {

	ResponseEntity<?> viewCart(int id);

	ResponseEntity<?> viewCartItems(int cid);

}
