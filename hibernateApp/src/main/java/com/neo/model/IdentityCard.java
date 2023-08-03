package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="identitycard")
@Data
public class IdentityCard {
	@Id
	private long cardId;
	private String cardName;
}
