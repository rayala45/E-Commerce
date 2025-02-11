package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.ProductDao;
import org.jsp.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private ProductRepository repository;

}
