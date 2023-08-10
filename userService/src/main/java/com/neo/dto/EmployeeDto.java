package com.neo.dto;

import javax.persistence.Column;

import lombok.Data;
@Data
public class EmployeeDto {
	private Long empId;
    private String empName;
    private String empEmail;
    private String empMobile;
    private Long addressId;
}
