package com.neo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="person")
@Data
public class Person {
	 @Id
	    private long pId;
	    private String name;
	    private String phNumber;
	    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
	    private List<Account> account;
	   
}
