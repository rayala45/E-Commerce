package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.PaymentDao;
import org.jsp.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDao dao;

}
