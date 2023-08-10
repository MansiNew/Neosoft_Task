package com.neo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class EmployeeAddress {
	@Id
	 private Long addressId;
	
	    private String city;
	    private String state;
	    private String country;
	    private String apartment;
	  
}
