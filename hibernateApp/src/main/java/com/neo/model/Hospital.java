package com.neo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
//refresh
@Entity
@Data
@Table(name="hospital")
public class Hospital {
	@Id
	private long hId;
	private String hName;
		@OneToOne(cascade = CascadeType.REFRESH,targetEntity=Building.class)
		@JoinColumn(name="bId")
	private Building building;
}
