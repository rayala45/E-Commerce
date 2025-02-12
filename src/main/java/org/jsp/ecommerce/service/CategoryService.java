package org.jsp.ecommerce.service;

import org.jsp.ecommerce.entity.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

	ResponseEntity<?> saveCategory(Category category);

	ResponseEntity<?> findAllCategory();

	ResponseEntity<?> findCategoryById(int id);

	ResponseEntity<?> findCategoryByName(String name);

	ResponseEntity<?> findAllProductsOfCategory(int cid);

}
