package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="school")
public class School {
	@Id
	private Long schId;
	private String name;
}
