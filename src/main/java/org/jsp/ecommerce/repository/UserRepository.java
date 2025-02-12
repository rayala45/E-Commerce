package org.jsp.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);

	List<User> findByRole(String role);

	Optional<User> findUserByPhoneAndPassword(long phone, String password);

	Optional<User> findUserByEmailAndPassword(String email, String password);

}
