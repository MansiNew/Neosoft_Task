package com.neo.dto;

import lombok.Data;

@Data
public class EmployeeAddtessDto {
	 private Long addressId;
	    private String city;
	    private String state;
	    private String country;
	    private String apartment;
}
