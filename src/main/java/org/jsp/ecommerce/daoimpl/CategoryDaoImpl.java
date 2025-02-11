package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.CategoryDao;
import org.jsp.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private CategoryRepository repository;

}
