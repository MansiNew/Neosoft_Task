package com.neo.feignapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.neo.dto.EmployeeAddtessDto;

@FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:3032")
public interface EmployeeFeignApi {
	
	 @GetMapping(value = "/findAddressById/{addressId}")
	   public  EmployeeAddtessDto getAddressById(@PathVariable("addressId") Long addressId);

	
}
