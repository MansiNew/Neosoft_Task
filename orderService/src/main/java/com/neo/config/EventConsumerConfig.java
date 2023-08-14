package com.neo.config;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neo.event.PaymentEvent;

@Configuration
public class EventConsumerConfig {
	@Autowired
	private OrderStatusUpdateHandler orderStatusHandler;
@Bean
	public Consumer<PaymentEvent> paymentEventConsumer(){
	//listen payment eventtopic and check payment status id success then complete order otherwise cancel order
		return (payment)->orderStatusHandler.updateOrder(payment.getPaymentRequestDto().getOrdetId(), purchaseOrder->{
			purchaseOrder.setPaymentStatus(payment.getPaymentStatus());
		});
	}
}
