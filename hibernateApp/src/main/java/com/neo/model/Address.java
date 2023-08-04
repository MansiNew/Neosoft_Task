package com.neo.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Data
@IdClass(AddressCompositeKey.class)
@Table(name="address")  
public class Address {
	
	@Id 
	private Long addId;
	
	@Id
	@Column(name="ADDRESS_CITY")
	private String city;
	
	@Id
	@Column(name="ADDRESS_STATE")
	private String state;
	
	@Id
	@Column(name="ADDRESS_COUNTRY")
	private String country;
	
	private String apartment;
}



