package com.neo.controller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.Employee;
import com.neo.service.EmployeeServie;



@RestController
public class EmployeeController {
	@Autowired
private EmployeeServie empService;
	@PostMapping("/create")
public void createEmployee(@RequestBody Employee employee) {
	empService.createEmployee(employee);
}
	
	@GetMapping("/findAll")
	public List<Employee> findAllEmployee() {
		return empService.findAllEmployee();
	}
	@GetMapping("/findEmp/{empId}")
	 public Employee findEmployeeById(@PathVariable("empId")Long empId) {
		return empService.findEmployeeById(empId);
	}
@DeleteMapping("/delete/{empId}")
	public void deleteEmployee(@PathVariable("empId") Long empId) {
		empService.deleteEmployee(empId);
	}
@PutMapping("/update")
public void updateEmployee(@RequestBody Employee employee) {
	empService.updateEmployee(employee);
}
@GetMapping("/findAllEmpByCriteriaQuery")
public List<Employee> findAllEmployeeByCriteriaQuery(){
	return empService.findAllEmployeeByCriteriaQuery();
}
@GetMapping("/findAllEmpGreaterSalary")
public List<Employee> findEmployeeWhoseSalaryIsHigherThan2000(){
	return empService.findEmployeeWhoseSalaryIsHigherThan2000();
}
@GetMapping("/findAllEmpNameStartsWithapt")
public List<Employee> findEmployeeNameStartsWithapt(){
	return empService.findEmployeeNameStartsWithapt();
}
}
