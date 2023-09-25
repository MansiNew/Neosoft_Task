package com.neo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.dto.OrderRequestDto;
import com.neo.event.OrderEvent;
import com.neo.event.OrderStatus;
import com.neo.event.PaymentEvent;
import com.neo.event.PaymentStatus;
import com.neo.model.Payment;
import com.neo.repo.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepo paymentRepo;
 
  @Autowired
  private KafkaTemplate<String, PaymentEvent> kafkaPaymentTemplate;
 
   @Autowired
   private KafkaTemplate<String, OrderEvent> kafkaOrderTemplate;
    
    public final Logger logger=LoggerFactory.getLogger(PaymentService.class);
    
    @Transactional
    @KafkaListener(topics = "orderApp", groupId = "orders-group")
    public void processPayment(String event) throws JsonMappingException, JsonProcessingException{
    	        System.out.println("Recieved event" + event);
      OrderEvent orderEvent = new ObjectMapper().readValue(event, OrderEvent.class);
      System.out.println("Recieved event" + orderEvent);
        OrderRequestDto order=orderEvent.getOredrRequestDto();
        Payment payment = new Payment();
  
        try {
            // save payment details in db
            payment.setAmount(order.getAmount());
            payment.setOrderId(order.getOrderId());
      payment.setProductId(order.getProductId());
      payment.setUserId(order.getUserId());
            payment.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESS);
         Payment save = paymentRepo.save(payment);
 
            // publish payment created event for inventory microservice to consume.
 
            PaymentEvent paymentEvent = new PaymentEvent();
           paymentEvent.setOrderRequestDto(orderEvent.getOredrRequestDto());
            paymentEvent.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESS);
       this.kafkaPaymentTemplate.send("paymentApp", paymentEvent);
      
       
      
        } catch (Exception e) {
        	e.printStackTrace();
            payment.setOrderId(order.getOrderId());
            payment.setPaymentStatus(PaymentStatus.PAYMENT_FAILED);
            paymentRepo.save(payment);
 
            // reverse previous task
            OrderEvent orderEvents = new OrderEvent();
       orderEvent.setOrderStatus(OrderStatus.ORDER_CANCELLED);
          orderEvent.setOredrRequestDto(order);
          this.kafkaOrderTemplate.send("reversed-orders", orderEvents);
 
        }
 
}
}
