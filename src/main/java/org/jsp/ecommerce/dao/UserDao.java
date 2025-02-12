package org.jsp.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.entity.User;

public interface UserDao {

	Optional<User> findUserByEmail(String email);

	User saveUser(User user);

	Optional<User> findUserById(int id);

	List<User> findAllUsers();

	List<User> findUserByRole(String role);

	void deleteById(int id);

	Optional<User> findUserByPhoneAndPassword(long phone, String password);

	Optional<User> findUserByEmailAndPassword(String email, String password);

}
