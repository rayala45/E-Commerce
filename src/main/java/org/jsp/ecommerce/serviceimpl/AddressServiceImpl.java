package org.jsp.ecommerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.AddressDao;
import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.entity.Address;
import org.jsp.ecommerce.entity.User;
import org.jsp.ecommerce.responsestructure.ResponseStructure;
import org.jsp.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao dao;

	@Autowired
	private UserDao userdao;

	@Override
	public ResponseEntity<?> saveAddress(Address address, int cid) {
		Optional<User> optional = userdao.findUserById(cid);
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid customer Id...");
		}
		address.setUser(optional.get());
		address = dao.saveAddress(address);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Address added successfully...").body(address).build());
	}

	@Override
	public ResponseEntity<?> updateAddress(Address address) {
		Optional<Address> optional = dao.findAddressById(address.getId());
		if (optional.isEmpty()) {
			throw new RuntimeException("invalid Address id...");
		}
		dao.saveAddress(address);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Address updated successfully...").body(address).build());
	}

	@Override
	public ResponseEntity<?> findAllAddress() {
		List<Address> al=dao.findAllAddresses();
		if(al.isEmpty()) {
			throw new RuntimeException("No Address found in the database...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Address found successfully...").body(al).build());
	}

	@Override
	public ResponseEntity<?> customerAddresses(int cid) {
		List<Address> al=dao.findAllAddressForUser(cid);
		if(al.isEmpty()) {
			throw new RuntimeException("No Address found in the database...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Address found successfully...").body(al).build());
	}

	@Override
	public ResponseEntity<?> deleteAddress(int id) {
		Optional<Address> optional = dao.findAddressById(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("invalid Address id...");
		}
		dao.deleteAddressById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Address found successfully...").body("deleted address successfully..").build());
	}

	@Override
	public ResponseEntity<?> searchAddress(String search) {
		List<Address> al=dao.findAddressByAnyValue(search);
		if(al.isEmpty()) {
			throw new RuntimeException("No valid Address  found with given...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Address found successfully...").body(al).build());
	}

	@Override
	public ResponseEntity<?> findAddressByfield(String text) {
		List<Address> al=dao.findAddressByfield(text);
		if(al.isEmpty()) {
			throw new RuntimeException("No valid Address  found with given...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Address found successfully...").body(al).build());
	}

}
