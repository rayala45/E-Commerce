package org.jsp.ecommerce.dao;

import java.util.Optional;

import org.jsp.ecommerce.entity.CartItem;

public interface CartitemsDao {

	CartItem saveCartItem(CartItem c);

	Optional<CartItem> findById(int cid);

}
