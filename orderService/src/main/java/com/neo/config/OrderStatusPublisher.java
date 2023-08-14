package com.neo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.neo.dto.OrderRequestDto;
import com.neo.event.OrderEvent;
import com.neo.event.OrderStatus;

import reactor.core.publisher.Sinks;

//@Component
@Service
public class OrderStatusPublisher {
	
@Autowired
	private Sinks.Many<OrderEvent> orderSinks;
//sink is a publisher just emit the event

public void publishOrderEvent(OrderRequestDto orderRequestDto,OrderStatus orderStatus) {
	OrderEvent orderEvent=new OrderEvent(orderRequestDto,orderStatus);
	
	//emit this event
	orderSinks.tryEmitNext(orderEvent);
}
}
