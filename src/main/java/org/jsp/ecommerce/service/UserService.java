package org.jsp.ecommerce.service;

import org.jsp.ecommerce.dto.UserLogin;
import org.jsp.ecommerce.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> updateUser(User user);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> findUsersById(int id);

	ResponseEntity<?> findUserByRole(String role);

	ResponseEntity<?> deleteById(int id);

	ResponseEntity<?> findUserByEmail(String email);

	ResponseEntity<?> userLogin(UserLogin login);

	ResponseEntity<?> otpVerify(int id, int otp);

}
