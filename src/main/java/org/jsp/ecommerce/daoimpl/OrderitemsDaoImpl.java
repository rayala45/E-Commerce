package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.OrderitemsDao;
import org.jsp.ecommerce.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderitemsDaoImpl implements OrderitemsDao{
	
	@Autowired
	private OrderItemsRepository repository;

}
