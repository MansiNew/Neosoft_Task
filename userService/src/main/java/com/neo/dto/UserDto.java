package com.neo.dto;

import javax.persistence.Column;

import lombok.Data;
@Data
public class UserDto {
	 private Long userId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String address;
	    private String mobile;
	    private String deptId;
}
