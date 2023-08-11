package com.neo.feignapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.neo.dto.EmployeeAddtessDto;
import com.neo.dto.EmployeeDto;
import com.neo.util.FeignClientUrlUtil;

@FeignClient(value = "DEPARTMENT-SERVICE", url =FeignClientUrlUtil.department_Service_Get_Address_URL)
public interface EmployeeFeignApi {
	
	 @GetMapping(value = FeignClientUrlUtil.Address_ID_Path)
	   public  EmployeeAddtessDto getAddressById(@PathVariable("addressId") Long addressId);
	 
	 @PostMapping("/saveEmployeeAddress")
	    public ResponseEntity<EmployeeAddtessDto> saveEmployeeAddress(@RequestBody EmployeeAddtessDto empAddress);
	
	
}
