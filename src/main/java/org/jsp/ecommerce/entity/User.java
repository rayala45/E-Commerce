package org.jsp.ecommerce.entity;

import org.jsp.ecommerce.util.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(unique = true,nullable = false,length=10)
	private long phone;
	@Column(nullable = false)
	private String password;
	
	private int otp;

	@Enumerated(EnumType.STRING)
	private Role role;

}
