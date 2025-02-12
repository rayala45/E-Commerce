package org.jsp.ecommerce.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.ProductDao;
import org.jsp.ecommerce.entity.Product;
import org.jsp.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> findAllProductsOfCategory(int cid) {
		return repository.findAllProductsByCategory(cid);
	}

	@Override
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		return repository.findAll();
	}

	@Override
	public Optional<Product> findProductById(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Product> findProductByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Product> findProductsInRange(int price) {
		return repository.findProductsInRange(price);
	}

	@Override
	public List<Product> filterProductsByPriceRange(int lprice, int hprice) {
		return repository.findProductsByPriceRange(lprice,hprice);
	}

	@Override
	public List<Product> findAllProductsByCategoryName(String name) {
		return repository.findAllProductsByCategoryName(name);
	}

	@Override
	public List<Product> findAllProductsByName(String name) {
		return repository.findBySearchProductName(name);
	}

}
