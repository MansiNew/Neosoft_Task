package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	private Long rollNum;
	private String name;
	private double marks;
	private String address;
	private String department;
}
