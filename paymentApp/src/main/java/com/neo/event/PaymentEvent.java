package com.neo.event;

import java.util.Date;
import java.util.UUID;

import com.neo.dto.OrderRequestDto;
import com.neo.dto.PaymentRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEvent implements Event {

	private UUID eventId = UUID.randomUUID();
	private PaymentStatus paymentStatus;
	private OrderRequestDto orderRequestDto;

	@Override
	public UUID getEventId() {
		// TODO Auto-generated method stub
		return eventId;
	}

}
