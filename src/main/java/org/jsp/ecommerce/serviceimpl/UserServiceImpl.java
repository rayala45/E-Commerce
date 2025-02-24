package org.jsp.ecommerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.CartDao;
import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.dto.UserLogin;
import org.jsp.ecommerce.entity.Cart;
import org.jsp.ecommerce.entity.User;
import org.jsp.ecommerce.responsestructure.ResponseStructure;
import org.jsp.ecommerce.service.UserService;
import org.jsp.ecommerce.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Autowired
	private CartDao cdao;

	@Autowired
	private Helper helper;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		Optional<User> optional = dao.findUserByEmail(user.getEmail());
		if (optional.isPresent()) {
			throw new RuntimeException("Email already Exist...");
		}
		user = dao.saveUser(user);
		Cart c=Cart.builder().user(user).build();
		cdao.saveCart(c);
		int otp=helper.OTPGenerator();
		helper.sendMail(user.getEmail(), "Account created successfully." + "\n Otp: " + otp,
				"Profile");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Account created successfully").body(user).build());
	}

	@Override
	public ResponseEntity<?> updateUser(User user) {
		Optional<User> optional = dao.findUserById(user.getId());
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid user id unable to update the values");
		}
		dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Account updated successfully").body(user).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> ul = dao.findAllUsers();
		if (ul.isEmpty()) {
			throw new RuntimeException("No users found in the database..");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Accounts fetched successfully").body(ul).build());
	}

	@Override
	public ResponseEntity<?> findUsersById(int id) {
		Optional<User> optional = dao.findUserById(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid user id unable to update the values");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Account fetched successfully by given id..").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findUserByRole(String role) {
		List<User> ul = dao.findUserByRole(role);
		if (ul.isEmpty()) {
			throw new RuntimeException("No users found in the database with given role: " + role);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Accounts fetched successfully by given role..").body(ul).build());
	}

	@Override
	public ResponseEntity<?> deleteById(int id) {
		Optional<User> optional = dao.findUserById(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid user id unable to delete the user");
		}
		dao.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Account fetched successfully by given id..").body("Account removed successfully..").build());
	}

	@Override
	public ResponseEntity<?> findUserByEmail(String email) {
		Optional<User> optional = dao.findUserByEmail(email);
		if (optional.isEmpty()) {
			throw new RuntimeException("No User found with given email..");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Account fetched successfully by given email..").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> userLogin(UserLogin login) {
		String email = login.getEmail();
		char ch = email.charAt(0);
		if (email.length() == 10 && (ch > '5' && ch <= '9')) {
			boolean flag = true;
			for (int i = 0; i < email.length(); i++) {
				if (!(email.charAt(i) >= '0' && email.charAt(i) <= '9')) {
					flag = false;
				}
			}
			if (flag) {
				Optional<User> optional = dao.findUserByPhoneAndPassword(Long.parseLong(login.getEmail()),
						login.getPassword());
				if (optional.isEmpty())
					throw new RuntimeException("Invalid user credentials..");
				int otp=helper.OTPGenerator();
				User user=optional.get();
				user.setOtp(otp);
				dao.saveUser(user);
				helper.sendMail(user.getEmail(), "OTP to login : "+otp, "login");
				return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
						.status(HttpStatus.OK.value()).message("OTP sent successfull...").body("OTP sent to the email...").build());
			}
		}
		Optional<User> optional = dao.findUserByEmailAndPassword(login.getEmail(), login.getPassword());
		if (optional.isEmpty())
			throw new RuntimeException("Invalid user credentials..");
		int otp=helper.OTPGenerator();
		User user=optional.get();
		user.setOtp(otp);
		dao.saveUser(user);
		helper.sendMail(user.getEmail(), "OTP to login : "+otp, "login");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("OTP sent successfull...").body("OTP sent to email..").build());

	}

	@Override
	public ResponseEntity<?> otpVerify(int id, int otp) {
		Optional<User> optional = dao.findUserById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("Invalid user id...");
		}
		User user = optional.get();
		if(user.getOtp()!=otp) {
			throw new RuntimeException("Entered wrong otp login again....");
		}
		user.setOtp(0);
		dao.saveUser(user);
		helper.sendMail(user.getEmail(), "login successfull..", "Login");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("otp verified successfully and login successfull.....").body(user).build());
	}

}
