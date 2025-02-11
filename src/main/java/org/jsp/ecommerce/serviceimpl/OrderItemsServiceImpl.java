package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.OrderitemsDao;
import org.jsp.ecommerce.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsServiceImpl implements OrderItemsService{
	
	@Autowired
	private OrderitemsDao dao;
}
