package org.jsp.ecommerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.CartDao;
import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.entity.Cart;
import org.jsp.ecommerce.entity.CartItem;
import org.jsp.ecommerce.entity.User;
import org.jsp.ecommerce.responsestructure.ResponseStructure;
import org.jsp.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao dao;

	@Autowired
	private UserDao udao;

	@Override
	public ResponseEntity<?> viewCart(int id) {
		Optional<User> optional = udao.findUserById(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("No user found in the database...");
		}
		Optional<Cart> c = dao.findCartById(id);
		if (c.isEmpty()) {
			throw new RuntimeException("No Cart found in the database...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Cart found successfully").body(c.get()).build());
	}

	@Override
	public ResponseEntity<?> viewCartItems(int cid) {
		Optional<Cart> optional = dao.findCartById(cid);
		if (optional.isEmpty()) {
			throw new RuntimeException("No Cart found in the database...");
		}
		Cart cart = optional.get();
		List<CartItem> cartItems = cart.getCartItems();
		if(cartItems.isEmpty()) {
			throw new RuntimeException(" Cart found empty in the database...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Cart found successfully").body(cartItems).build());

	}

}
