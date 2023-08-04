package com.neo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employee")
public class Employee {
	@Id
	private Long empId;
	private String name;
	private double salary;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deptId",referencedColumnName="deptId")
	private Department department;
}

