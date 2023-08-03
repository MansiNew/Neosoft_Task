package com.neo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="subject")
public class Subject {
	@Id
	private long subId;
	private String subName;
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="sub_Id")
	    private Student student;
}
