package org.jsp.ecommerce.service;

import org.jsp.ecommerce.entity.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {

	ResponseEntity<?> saveProduct(Product product);

	ResponseEntity<?> findAllProducts();

	ResponseEntity<?> findProductById(int id);

	ResponseEntity<?> findAllProductsByName(String name);

	ResponseEntity<?> filterProductsByRange(int price);

	ResponseEntity<?> filterProductsByPriceRange(int lprice, int hprice);

	ResponseEntity<?> findAllProductsByCategory(int id);

	ResponseEntity<?> findAllProductsByCategoryName(String name);

	ResponseEntity<?> searchProductsByName(String name);

}
