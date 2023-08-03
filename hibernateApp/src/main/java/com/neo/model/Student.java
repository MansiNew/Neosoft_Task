package com.neo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;




@Entity
@Data
@Table(name="student")
public class Student {
	@Id
private long sId;
private String name;
@OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE,fetch=FetchType.EAGER)
private List<Subject> subject;
@OneToOne(cascade = CascadeType.MERGE,targetEntity=School.class)
private School school;
}
