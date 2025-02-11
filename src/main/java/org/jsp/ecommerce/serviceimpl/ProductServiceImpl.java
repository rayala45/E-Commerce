package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.ProductDao;
import org.jsp.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

}
