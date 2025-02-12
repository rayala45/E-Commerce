package org.jsp.ecommerce.repository;

import java.util.List;

import org.jsp.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query("SELECT a FROM Address a where a.user.id=:cid")
	List<Address> findAddressByUserId(@Param(value="cid") int cid);

	@Query("SELECT a FROM Address a WHERE " +
		       "a.street LIKE %:search% OR " +
		       "a.state LIKE %:search% OR " +
		       "a.city LIKE %:search% OR " +
		       "a.postalCode LIKE %:search% OR " +
		       "a.country LIKE %:search%")
	List<Address> findAddressBySearchBy(@Param(value="search") String search);

	
	@Query("SELECT a FROM Address a WHERE " +
		       "a.street=:text OR " +
		       "a.state=:text OR " +
		       "a.city=:text OR " +
		       "a.postalCode=:text OR " +
		       "a.country=:text")
	List<Address> findAddressByfield(@Param(value="text") String text);

}
