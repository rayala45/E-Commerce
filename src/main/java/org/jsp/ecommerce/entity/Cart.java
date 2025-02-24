package org.jsp.ecommerce.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @OneToOne
	    @MapsId
	    private User user;

	    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	    private List<CartItem> cartItems;

}
