package com.neo.dto;

import com.neo.event.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
	private int userId;
	private int productId;
	private int amount;
	private int ordetId;
	private OrderStatus orderStatus;
}