package com.neo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="student")
public class Student {
	
	@Id
	private Long stId;
	
	private String stName;
	
	private String marks;
	
	private String department;
	
	private int age;
	
	private String mobile;
	
}
