package org.jsp.ecommerce.repository;

import org.jsp.ecommerce.entity.payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<payment, Integer> {

}
