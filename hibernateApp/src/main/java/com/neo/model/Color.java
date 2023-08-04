package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="color")
@Data
public class Color {
	@Id
	private long cId;
	private String cName;
}
