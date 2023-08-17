package com.neo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Entity
@Data
@RedisHash("STUDENT")
public class Student implements Serializable {
	@Id
	private Long rollNum;
	private String name;
	private double marks;
	private String address;
	private String department;
}
