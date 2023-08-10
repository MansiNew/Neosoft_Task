package com.neo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Employee {
	
	 @Id
	 private Long empId;
	
	    private String empName;
	    
	    @Column(nullable = false, unique = true)
	    private String empEmail;
	   
	    private String empMobile;
	    private Long addressId;
}
