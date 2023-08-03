package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="building")
public class Building {
	@Id
	private long bId;
	private String bName;
	private String bNumber;
}
