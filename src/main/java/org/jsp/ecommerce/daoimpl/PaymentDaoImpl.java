package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.PaymentDao;
import org.jsp.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao{
	
	@Autowired
	private PaymentRepository repository;
	

}
