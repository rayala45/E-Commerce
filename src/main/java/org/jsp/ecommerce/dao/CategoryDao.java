package org.jsp.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.entity.Category;

public interface CategoryDao {

	Optional<Category> findCategoryByName(String name);

	Category saveCategory(Category category);

	List<Category> findAllCategory();

	Optional<Category> findCategoryById(int id);

}
