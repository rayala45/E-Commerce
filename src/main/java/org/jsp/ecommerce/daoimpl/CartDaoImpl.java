package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.CartDao;
import org.jsp.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private CartRepository repository;

}
