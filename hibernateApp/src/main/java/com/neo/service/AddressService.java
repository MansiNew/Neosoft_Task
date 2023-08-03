package com.neo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.AddressDao;
import com.neo.model.Address;
import com.neo.model.Employee;
@Service
public class AddressService {
	@Autowired
	 AddressDao addressDao;
	@Transactional
	public void createAddress(Address address) {
		addressDao.createAddress(address);
	}
	@Transactional
	 public List<Address> findAllAddress(){
		return addressDao.findAllAddress();
	}
	/*@Transactional
	public Address findAddressById(Long addId) {
		return addressDao.findAddressById(addId);
	}*/
	
}
