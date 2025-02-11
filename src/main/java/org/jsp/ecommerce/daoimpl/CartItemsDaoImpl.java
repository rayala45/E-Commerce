package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.CartitemsDao;
import org.jsp.ecommerce.repository.CartitemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartItemsDaoImpl implements CartitemsDao{

	
	@Autowired
	private CartitemsRepository repository;
}
