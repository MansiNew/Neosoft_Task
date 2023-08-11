package com.neo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.neo.dto.EmployeeAddtessDto;
import com.neo.dto.EmployeeDto;
import com.neo.dto.EmployeeResponseDto;
import com.neo.exception.InternalServerException;
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
	 
	 public EmployeeResponseDto findEmployee(Long empId) throws InternalServerException {
		 
		 EmployeeResponseDto empResponseDto = new EmployeeResponseDto();
		  EmployeeAddtessDto employeeAddressDto=null;
	     Employee employee= empRepo.findById(empId).get();
	        EmployeeDto employeeDto = mapToEmployee(employee);
	        try {
	        employeeAddressDto=empFeignApi.getAddressById(employee.getAddressId());
	        }
	        catch(Exception e) {
	        	throw new InternalServerException("here may be have some issue to hit departmentservice to get employee with  address of employee");
	        }
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
	
	 public ResponseEntity<EmployeeAddtessDto> saveEmployeeAddress(@RequestBody EmployeeAddtessDto empAddress) throws InternalServerException{
		 ResponseEntity<EmployeeAddtessDto> saveEmployeeAddress=null;
		 try {
		 saveEmployeeAddress = empFeignApi.saveEmployeeAddress(empAddress);}
		 catch(Exception e) {
	        	throw new InternalServerException("here may be have some issue to hit departmentservice to save employee address");
	        }
		 return saveEmployeeAddress;
	 }
	
	
}
