package org.jsp.ecommerce.daoimpl;

import java.util.Optional;

import org.jsp.ecommerce.dao.CartitemsDao;
import org.jsp.ecommerce.entity.CartItem;
import org.jsp.ecommerce.repository.CartitemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartItemsDaoImpl implements CartitemsDao{

	
	@Autowired
	private CartitemsRepository repository;

	@Override
	public CartItem saveCartItem(CartItem c) {
		return repository.save(c);
	}

	@Override
	public Optional<CartItem> findById(int cid) {
		return repository.findById(cid);
	}
}
