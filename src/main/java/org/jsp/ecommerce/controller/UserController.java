package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.dto.UserLogin;
import org.jsp.ecommerce.entity.User;
import org.jsp.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	@PatchMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		return service.findAllUsers();
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findUsersById(@PathVariable int id){
		return service.findUsersById(id);
	}
	
	@GetMapping("/findByRole/{role}")
	public ResponseEntity<?> findUserByRole(@PathVariable String role){
		return service.findUserByRole(role);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<?> findUserByEmail(@PathVariable String email){
		return service.findUserByEmail(email);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserLogin login){
		return service.userLogin(login);
	}
	
	@GetMapping("/otpVerify/{id}/{otp}")
	public ResponseEntity<?> otpVerify(@PathVariable int id,@PathVariable int otp){
		return service.otpVerify(id,otp);
	}
	
	
	

}
