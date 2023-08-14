package com.neo.config;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neo.event.OrderEvent;
import com.neo.event.OrderStatus;
import com.neo.event.PaymentEvent;
import com.neo.service.PaymentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class PaymentConsumerConfig {
	@Autowired
	private PaymentService paymentService;

	//consume flux orderevent and publish paymentevent,process data and validate payment and publish in paymentevent
	@Bean
	public Function<Flux<OrderEvent>,Flux<PaymentEvent>> paymentProcessor(){
		return orderEventFlux ->orderEventFlux.flatMap(this::processPayment);
	}
	
	private Mono<PaymentEvent> processPayment(OrderEvent orderEvent){
		if(OrderStatus.ORDER_CREATED.equals(orderEvent.getOrderStatus())) {
			return Mono.fromSupplier(()->this.paymentService.newOrderEvent(orderEvent));
		}
		else {
			return Mono.fromRunnable(()->this.paymentService.cancelOrderEvent(orderEvent));
		}
	}
}
