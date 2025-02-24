package org.jsp.ecommerce.daoimpl;

import java.util.Optional;

import org.jsp.ecommerce.dao.CartDao;
import org.jsp.ecommerce.entity.Cart;
import org.jsp.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private CartRepository repository;

	@Override
	public Cart saveCart(Cart c) {
		return repository.save(c);
	}

	@Override
	public Optional<Cart> findCartById(int id) {
		return repository.findById(id);
	}

}
