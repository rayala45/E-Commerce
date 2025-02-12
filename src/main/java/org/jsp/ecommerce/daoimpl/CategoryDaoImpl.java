package org.jsp.ecommerce.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.CategoryDao;
import org.jsp.ecommerce.entity.Category;
import org.jsp.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private CategoryRepository repository;

	@Override
	public Optional<Category> findCategoryByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Category saveCategory(Category category) {
		return repository.save(category);
	}

	@Override
	public List<Category> findAllCategory() {
		return repository.findAll();
	}

	@Override
	public Optional<Category> findCategoryById(int id) {
		return repository.findById(id);
	}

}
