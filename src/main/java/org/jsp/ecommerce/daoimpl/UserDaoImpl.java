package org.jsp.ecommerce.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.entity.User;
import org.jsp.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepository repository;

	@Override
	public Optional<User> findUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public Optional<User> findUserById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return repository.findAll();
	}

	@Override
	public List<User> findUserByRole(String role) {
		return repository.findByRole(role);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<User> findUserByPhoneAndPassword(long phone, String password) {
		return repository.findUserByPhoneAndPassword(phone,password);
	}

	@Override
	public Optional<User> findUserByEmailAndPassword(String email, String password) {
		return repository.findUserByEmailAndPassword(email,password);
	}

}
