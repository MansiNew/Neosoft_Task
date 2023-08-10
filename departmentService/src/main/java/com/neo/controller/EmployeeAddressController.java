package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.Department;
import com.neo.model.EmployeeAddress;
import com.neo.repo.EmployeeAddressRepo;
import com.neo.service.EmployeeAddressService;

@RestController
public class EmployeeAddressController {
	
	@Autowired
	private EmployeeAddressService empAddressService;
	
	@PostMapping("/saveEmployeeAddress")
    public ResponseEntity<EmployeeAddress> saveDepartment(@RequestBody EmployeeAddress empAddress){
        EmployeeAddress savedEmpAddress = empAddressService.saveEmployeeAddress(empAddress);
        return new ResponseEntity<>(savedEmpAddress , HttpStatus.CREATED);
    }

    @GetMapping("/findAddressById/{addressId}")
    public ResponseEntity<EmployeeAddress> getAddressById(@PathVariable("addressId") Long addressId){
    	EmployeeAddress employeeAddress=  empAddressService.getEmployeeAddByById(addressId);
        return ResponseEntity.ok(employeeAddress);
    }
}
