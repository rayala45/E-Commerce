package org.jsp.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.category.id=:cid")
	List<Product> findAllProductsByCategory(@Param(value = "cid") int cid);

	Optional<Product> findByName(String name);

	@Query("SELECT p FROM Product p WHERE p.price>:price")
	List<Product> findProductsInRange(@Param(value = "price") int price);

	@Query("SELECT p FROM Product p WHERE p.price>:lprice AND p.price<:hprice")
	List<Product> findProductsByPriceRange(int lprice, int hprice);

	@Query("SELECT p FROM Product p WHERE p.category.name=:name")
	List<Product> findAllProductsByCategoryName(@Param(value = "name") String name);

	@Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
	List<Product> findBySearchProductName(@Param(value = "name") String name);

}
