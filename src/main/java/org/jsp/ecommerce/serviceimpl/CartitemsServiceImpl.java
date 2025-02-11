package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.CartitemsDao;
import org.jsp.ecommerce.service.CartitemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartitemsServiceImpl implements CartitemsService{
	@Autowired
	private CartitemsDao dao;

}
