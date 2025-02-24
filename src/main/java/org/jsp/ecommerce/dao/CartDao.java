package org.jsp.ecommerce.dao;

import java.util.Optional;

import org.jsp.ecommerce.entity.Cart;

public interface CartDao {

	Cart saveCart(Cart c);

	Optional<Cart> findCartById(int id);

}
