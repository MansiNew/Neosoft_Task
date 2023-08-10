package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Department {
	@Id
	private Long deptId;
	
    private String deptName;
    private String deptAddress;
    private String deptCode;
}
