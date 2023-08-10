package com.neo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.neo.dto.EmployeeAddtessDto;
import com.neo.dto.EmployeeDto;
import com.neo.dto.EmployeeResponseDto;
import com.neo.feignapi.EmployeeFeignApi;
import com.neo.model.Employee;
import com.neo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private EmployeeFeignApi empFeignApi;
	
	 public Employee saveEmployee(Employee employee) {
		 return empRepo.save(employee);
	 }
	 
	 public EmployeeResponseDto findEmployee(Long empId) {
		 
		 EmployeeResponseDto empResponseDto = new EmployeeResponseDto();
	     Employee employee= empRepo.findById(empId).get();
	        EmployeeDto employeeDto = mapToEmployee(employee);
	        EmployeeAddtessDto employeeAddressDto=empFeignApi.getAddressById(employee.getAddressId());
	        empResponseDto.setEmployee(employeeDto);
	        empResponseDto.setEmployeeAddress(employeeAddressDto);
	return empResponseDto;
	 }

	public EmployeeDto mapToEmployee(Employee employee) {
		// TODO Auto-generated method stub
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setEmpId(employee.getEmpId());
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setEmpEmail(employee.getEmpEmail());
		employeeDto.setEmpMobile(employee.getEmpMobile());
		employeeDto.setAddressId(employee.getAddressId());
		return employeeDto;
	}
}
