package com.neo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="school")
public class School {
	@Id
	private long schId;
	private String schName;
}
