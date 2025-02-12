package org.jsp.ecommerce.service;

import org.jsp.ecommerce.entity.Address;
import org.springframework.http.ResponseEntity;

public interface AddressService {


	ResponseEntity<?> saveAddress(Address address, int cid);

	ResponseEntity<?> updateAddress(Address address);

	ResponseEntity<?> findAllAddress();

	ResponseEntity<?> customerAddresses(int cid);

	ResponseEntity<?> deleteAddress(int id);

	ResponseEntity<?> searchAddress(String search);

	ResponseEntity<?> findAddressByfield(String text);

}
