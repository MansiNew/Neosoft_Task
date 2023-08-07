package com.neo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
//detach
@Entity
@Table(name="user")
@Data
public class User {
	@Id
	private long uId;
	private String uName;
		@OneToOne(cascade = CascadeType.REMOVE,targetEntity=IdentityCard.class)
		@JoinColumn(name="cardId")
	private IdentityCard identityCard;
}
