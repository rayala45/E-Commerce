package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.CategoryDao;
import org.jsp.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao dao;

}
