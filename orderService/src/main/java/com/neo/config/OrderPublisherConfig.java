package com.neo.config;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neo.event.OrderEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class OrderPublisherConfig {

	@Bean
	public Sinks.Many<OrderEvent> orderSinks(){
		return Sinks.many().multicast().onBackpressureBuffer();
	}
	
	//kafla publisher
	@Bean
	public Supplier<Flux<OrderEvent>>orderSupplier(Sinks.Many<OrderEvent> sinks){
		return sinks::asFlux;
	}
	
}
