package org.jsp.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.entity.Address;

public interface AddressDao {

	Address saveAddress(Address address);

	Optional<Address> findAddressById(int id);

	List<Address> findAllAddresses();

	List<Address> findAllAddressForUser(int cid);

	void deleteAddressById(int id);

	List<Address> findAddressByAnyValue(String search);

	List<Address> findAddressByfield(String text);

}
