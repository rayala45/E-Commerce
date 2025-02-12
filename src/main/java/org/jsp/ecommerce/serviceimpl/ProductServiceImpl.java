package org.jsp.ecommerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.ProductDao;
import org.jsp.ecommerce.entity.Product;
import org.jsp.ecommerce.responsestructure.ResponseStructure;
import org.jsp.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	public ResponseEntity<?> saveProduct(Product product) {
		product = dao.saveProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Product saved successfully..").body(product).build());
	}

	@Override
	public ResponseEntity<?> findAllProducts() {
		List<Product> pl = dao.findAllProducts();
		if (pl.isEmpty()) {
			throw new RuntimeException("No products found in the database...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Product found successfully..").body(pl).build());
	}

	@Override
	public ResponseEntity<?> findProductById(int id) {
		Optional<Product> optional=dao.findProductById(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("No product found in the database by given id...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Product found successfully..").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllProductsByName(String name) {
		Optional<Product> optional=dao.findProductByName(name);
		if (optional.isEmpty()) {
			throw new RuntimeException("No product found in the database by given name...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Product found successfully..").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> filterProductsByRange(int price) {
		List<Product> pl=dao.findProductsInRange(price);
		if (pl.isEmpty()) {
			throw new RuntimeException("No product found in the database by given name...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Products found successfully..").body(pl).build());
		
	}

	@Override
	public ResponseEntity<?> filterProductsByPriceRange(int lprice, int hprice) {
		List<Product> pl=dao.filterProductsByPriceRange(lprice,hprice);
		if (pl.isEmpty()) {
			throw new RuntimeException("No product found in the database in given range...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Products found successfully..").body(pl).build());
	}

	@Override
	public ResponseEntity<?> findAllProductsByCategory(int id) {
		List<Product> pl = dao.findAllProductsOfCategory(id);
		if (pl.isEmpty()) {
			throw new RuntimeException("No product found in the database in given category...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Products found successfully..").body(pl).build());
	}

	@Override
	public ResponseEntity<?> findAllProductsByCategoryName(String name) {
		List<Product> pl = dao.findAllProductsByCategoryName(name);
		if (pl.isEmpty()) {
			throw new RuntimeException("No product found in the database in given category name...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Products found successfully..").body(pl).build());
	}

	@Override
	public ResponseEntity<?> searchProductsByName(String name) {
		List<Product> pl =dao.findAllProductsByName(name);
		return null;
	}

}
