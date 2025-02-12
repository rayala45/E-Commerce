package org.jsp.ecommerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.CategoryDao;
import org.jsp.ecommerce.dao.ProductDao;
import org.jsp.ecommerce.entity.Category;
import org.jsp.ecommerce.entity.Product;
import org.jsp.ecommerce.responsestructure.ResponseStructure;
import org.jsp.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao dao;
	
	@Autowired
	private ProductDao pdao;

	@Override
	public ResponseEntity<?> saveCategory(Category category) {
		Optional<Category> optional = dao.findCategoryByName(category.getName());
		if (optional.isPresent()) {
			throw new RuntimeException("The category already exist in the database..");
		}
		category = dao.saveCategory(category);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("category was created...").body(category).build());
	}

	@Override
	public ResponseEntity<?> findAllCategory() {
		List<Category> cl=dao.findAllCategory();
		if(cl.isEmpty()) {
			throw new RuntimeException("No category found in the database...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("category was found successfully...").body(cl).build());
	}

	@Override
	public ResponseEntity<?> findCategoryById(int id) {
		Optional<Category> optional=dao.findCategoryById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("No category found in the database by given id...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("category was found successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findCategoryByName(String name) {
		Optional<Category> optional=dao.findCategoryByName(name);
		if(optional.isEmpty()) {
			throw new RuntimeException("No category found in the database by given name...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("category was found successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllProductsOfCategory(int cid) {
		List<Product> pl=pdao.findAllProductsOfCategory(cid);
		if(pl.isEmpty()) {
			throw new RuntimeException("No products in that category..");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("products was found successfully...").body(pl).build());
	}

}
