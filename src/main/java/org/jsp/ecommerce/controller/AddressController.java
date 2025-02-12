package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.entity.Address;
import org.jsp.ecommerce.service.AddressService;
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
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService service;
	
	@PostMapping("/{cid}")
	public ResponseEntity<?> saveAddress(@RequestBody Address address,@PathVariable int cid){
		return service.saveAddress(address,cid);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateAddress(@RequestBody Address address){
		return service.updateAddress(address);
	}

	@GetMapping
	public ResponseEntity<?> findAllAddress(){
		return service.findAllAddress();
	}
	
	@GetMapping("/customer/{cid}")
	public ResponseEntity<?> customerAddresses(@PathVariable int cid){
		return service.customerAddresses(cid);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable int id){
		return service.deleteAddress(id);
	}
	
	@GetMapping("/search/{search}")
	public ResponseEntity<?> searchAddress(@PathVariable String search){
		return service.searchAddress(search);
	}
	
	@GetMapping("/findBy/{text}")
	public ResponseEntity<?> findAddressByfield(@PathVariable String text){
		return service.findAddressByfield(text);
	}
	

	
}
