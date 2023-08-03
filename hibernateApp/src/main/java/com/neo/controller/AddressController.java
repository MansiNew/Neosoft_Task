package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.neo.model.Address;
import com.neo.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
		@PostMapping("/createAddress")
	public void createAddress(@RequestBody Address address) {
			addressService.createAddress(address);
		
		}
	
		@GetMapping("/findAllAddress")
		public List<Address> findAllAddress() {
			return addressService.findAllAddress();
		}
		
		
}
