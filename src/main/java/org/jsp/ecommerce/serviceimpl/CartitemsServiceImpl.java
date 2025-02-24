package org.jsp.ecommerce.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.CartDao;
import org.jsp.ecommerce.dao.CartitemsDao;
import org.jsp.ecommerce.dao.ProductDao;
import org.jsp.ecommerce.entity.Cart;
import org.jsp.ecommerce.entity.CartItem;
import org.jsp.ecommerce.entity.Product;
import org.jsp.ecommerce.responsestructure.ResponseStructure;
import org.jsp.ecommerce.service.CartitemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartitemsServiceImpl implements CartitemsService {
	@Autowired
	private CartitemsDao dao;

	@Autowired
	private CartDao cdao;

	@Autowired
	private ProductDao pdao;

	@Override
	public ResponseEntity<?> saveCartitem(int cid, int pid) {
		Optional<Cart> optional = cdao.findCartById(cid);
		if (optional.isEmpty()) {
			throw new RuntimeException("No cart found for the user ...");
		}
		Optional<Product> optional2 = pdao.findProductById(pid);
		if (optional2.isEmpty()) {
			throw new RuntimeException("No cart found for the user ...");
		}
		Cart cart = optional.get();
		Product p = optional2.get();
		CartItem c = CartItem.builder().cart(cart).product(p).quantity(1).build();
		c = dao.saveCartItem(c);
		List<CartItem> cartItems = cart.getCartItems();
		if (cartItems.isEmpty()) {
			ArrayList<CartItem> al = new ArrayList<>();
			al.add(c);
		} else {
			cartItems.add(c);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("cart item added to cart").body(c).build());
	}

	@Override
	public ResponseEntity<?> changingQuantity(int cid, int quan) {
		Optional<CartItem> optional = dao.findById(cid);
		if (optional.isEmpty()) {
			throw new RuntimeException("No cart found for the user ...");
		}
		CartItem cartItem = optional.get();
		cartItem.setQuantity(quan);
		dao.saveCartItem(cartItem);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("cart item added to cart").body(cartItem).build());
	}

}
