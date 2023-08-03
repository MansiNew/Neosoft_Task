package com.neo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class AddressCompositeKey implements Serializable {
	
	private String city;
	private String state;
	private String country;
}
