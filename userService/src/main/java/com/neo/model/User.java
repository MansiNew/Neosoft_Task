package com.neo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class User {
	
	    @Id
	    private Long userId;
	 
	    private String firstName;
	    private String lastName;
	    
	    @Column(nullable = false, unique = true)
	    private String email;
	    
	    private String address;
	    private String mobile;
	    private String deptId;
}
