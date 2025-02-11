package org.jsp.ecommerce.repository;

import org.jsp.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartitemsRepository extends JpaRepository<CartItem, Integer>{

}
