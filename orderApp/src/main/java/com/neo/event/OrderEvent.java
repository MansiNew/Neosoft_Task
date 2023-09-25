package com.neo.event;

import com.neo.dto.OrderRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent implements Event {

	private UUID eventId = UUID.randomUUID();
	private OrderRequestDto oredrRequestDto;
	private OrderStatus orderStatus;

	public UUID getEventId() {
		return eventId;
	}

	public OrderEvent(OrderRequestDto oredrRequestDto, OrderStatus orderStatus) {
		super();
		this.oredrRequestDto = oredrRequestDto;
		this.orderStatus = orderStatus;
	}

}
