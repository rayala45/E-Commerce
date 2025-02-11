package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.AddressDao;
import org.jsp.ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl implements AddressDao{
	@Autowired
	private AddressRepository repository;

}
