package org.jsp.ecommerce.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.AddressDao;
import org.jsp.ecommerce.entity.Address;
import org.jsp.ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl implements AddressDao{
	@Autowired
	private AddressRepository repository;

	@Override
	public Address saveAddress(Address address) {
		return repository.save(address);
	}

	@Override
	public Optional<Address> findAddressById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Address> findAllAddresses() {
		return repository.findAll();
	}

	@Override
	public List<Address> findAllAddressForUser(int cid) {
		return repository.findAddressByUserId(cid);
	}

	@Override
	public void deleteAddressById(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Address> findAddressByAnyValue(String search) {
		return repository.findAddressBySearchBy(search);
	}

	@Override
	public List<Address> findAddressByfield(String text) {
		return repository.findAddressByfield(text);
	}

}
