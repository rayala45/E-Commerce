package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.OrdersDao;
import org.jsp.ecommerce.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl implements OrdersDao{
	@Autowired
	private OrdersRepository repository;

}
