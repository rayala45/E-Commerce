package org.jsp.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.entity.Product;

public interface ProductDao {

	List<Product> findAllProductsOfCategory(int cid);

	Product saveProduct(Product product);

	List<Product> findAllProducts();

	Optional<Product> findProductById(int id);

	Optional<Product> findProductByName(String name);

	List<Product> findProductsInRange(int price);

	List<Product> filterProductsByPriceRange(int lprice, int hprice);

	List<Product> findAllProductsByCategoryName(String name);

	List<Product> findAllProductsByName(String name);

}
