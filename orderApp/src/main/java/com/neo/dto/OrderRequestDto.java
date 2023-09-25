package com.neo.dto;

import lombok.Data;

@Data
public class OrderRequestDto {
	
private int userId;
private int productId;
private int amount;
private int orderId;
}
