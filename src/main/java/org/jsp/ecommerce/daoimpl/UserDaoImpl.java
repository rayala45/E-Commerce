package org.jsp.ecommerce.daoimpl;

import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepository repository;

}
