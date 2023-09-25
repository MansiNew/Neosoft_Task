package com.neo.kafkaconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.dto.OrderRequestDto;
import com.neo.event.OrderEvent;
import com.neo.event.OrderStatus;
import com.neo.event.PaymentEvent;
import com.neo.event.PaymentStatus;
import com.neo.model.Payment;
import com.neo.repo.PaymentRepo;

@Component
public class ReversePayment {
	@Autowired
    private PaymentRepo paymentRepo;
 
   /* @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaOrderTemplate;
 
	@KafkaListener(topics = "reversed-payments", groupId = "payments-group")
	public void reversePayment(String event) {

		try {

			PaymentEvent paymentEvent = new ObjectMapper().readValue(event, PaymentEvent.class);
			OrderRequestDto order = paymentEvent.getOrderRequestDto();

			// do refund..

			// update status as failed

			Optional<Payment> payments = paymentRepo.findById(order.getUserId());

			if (payments.isPresent()) {
				Payment payment = payments.get();
				payment.setPaymentStatus(PaymentStatus.PAYMENT_FAILED);
			}

			// reverse previous task
			OrderEvent orderEvent = new OrderEvent();
			orderEvent.setOredrRequestDto(paymentEvent.getOrderRequestDto());
			orderEvent.setOrderStatus(OrderStatus.ORDER_CANCELLED);
			this.kafkaOrderTemplate.send("reversed-orders", orderEvent);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}*/
}