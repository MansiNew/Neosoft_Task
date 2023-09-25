package com.neo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.neo.event.OrderStatus;
import com.neo.event.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name="ORDER")
@Data
public class PurchaseOrder {
	@Id
private int id;
private int productId;
private int userId;
private int price;
@Enumerated(EnumType.STRING)
private OrderStatus orderStatus;
@Enumerated(EnumType.STRING)
private PaymentStatus paymentStatus;
}
