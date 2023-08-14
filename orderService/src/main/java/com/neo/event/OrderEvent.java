package com.neo.event;

import org.apache.kafka.common.Uuid;

import com.neo.dto.OrderRequestDto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class OrderEvent implements Event{
	private UUID eventId=UUID.randomUUID();
private OrderRequestDto oredrRequestDto;
private OrderStatus orderStatus;
private Date eventDate =new Date();
public UUID getEventId() {
	return eventId;
}
public Date getDate() {
	return eventDate;
}
public OrderEvent(OrderRequestDto oredrRequestDto, OrderStatus orderStatus) {
	super();
	this.oredrRequestDto = oredrRequestDto;
	this.orderStatus = orderStatus;
}

}
