package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.CartDao;
import org.jsp.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao dao;

}
