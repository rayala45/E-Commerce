package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.AddressDao;
import org.jsp.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressDao dao;

}
