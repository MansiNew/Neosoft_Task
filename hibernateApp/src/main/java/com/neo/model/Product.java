package com.neo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
	@Id
	private long prId;
	private String prName;
		@OneToOne(cascade = CascadeType.DETACH,targetEntity=Color.class)
		@JoinColumn(name="cId")
	private Color color;
}
