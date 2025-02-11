package org.jsp.ecommerce.serviceimpl;

import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;

}
