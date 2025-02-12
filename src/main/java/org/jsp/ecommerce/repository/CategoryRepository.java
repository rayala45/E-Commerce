package org.jsp.ecommerce.repository;

import java.util.Optional;

import org.jsp.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Optional<Category> findByName(String name);

}
