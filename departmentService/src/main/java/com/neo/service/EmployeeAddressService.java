package com.neo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.model.Department;
import com.neo.model.EmployeeAddress;
import com.neo.repo.EmployeeAddressRepo;

@Service
public class EmployeeAddressService {
	
	@Autowired
private EmployeeAddressRepo empAddressRepo;
	
	public EmployeeAddress saveEmployeeAddress(EmployeeAddress empAddress) {
		return empAddressRepo.save(empAddress);
	}
	
	 public EmployeeAddress getEmployeeAddByById(Long addressId) {
	        return empAddressRepo.findById(addressId).get();
	    }
	 
	
}
