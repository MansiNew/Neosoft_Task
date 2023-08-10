package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.EmployeeResponseDto;
import com.neo.model.Employee;
import com.neo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = empService.saveEmployee(employee);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/findEmployeeWithAddress/{empId}")
	public ResponseEntity<EmployeeResponseDto> findEmployee(@PathVariable("empId") Long empId) {
		EmployeeResponseDto employeeResponseDto = empService.findEmployee(empId);
		return ResponseEntity.ok(employeeResponseDto);
	}
}
