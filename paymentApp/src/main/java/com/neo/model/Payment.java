package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.neo.event.PaymentStatus;

import lombok.Data;

@Data
@Entity
@Table(name="PAYMENT")
public class Payment {
	@Id
private int userId;
	
private int productId;
private int amount;
private int orderId;
@Enumerated(EnumType.STRING)
private PaymentStatus paymentStatus;
}
