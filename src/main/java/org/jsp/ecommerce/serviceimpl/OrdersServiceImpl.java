package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.OrdersDao;
import org.jsp.ecommerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersDao dao;

}
