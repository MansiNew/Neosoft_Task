package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="account")
@Data
public class Account {
	 @Id
	    private long accId;
	    private String bankName;
	    private String accNumber;
	    @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="p_Id")
	    private Person person;
}
