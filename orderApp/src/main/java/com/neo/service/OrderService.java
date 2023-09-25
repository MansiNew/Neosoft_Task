package com.neo.service;



import java.util.List;
import java.util.Optional;

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
import com.neo.model.PurchaseOrder;

import com.neo.repo.PurchaseOrderRepo;

@Service
public class OrderService {
	
@Autowired
	private  PurchaseOrderRepo purchaseOrderRepo;

@Autowired
private KafkaTemplate<String, OrderEvent> kafkaTemplate;

public final Logger logger=LoggerFactory.getLogger(OrderService.class);
//exceute in single transation

@Transactional
public void createOrder(OrderRequestDto orderRequestDto) {
	PurchaseOrder order = new PurchaseOrder();
	OrderEvent event = new OrderEvent();

	try {
		order.setId(orderRequestDto.getOrderId());
		order.setOrderStatus(OrderStatus.ORDER_CREATED);
		order.setPrice(orderRequestDto.getAmount());
		order.setUserId(orderRequestDto.getUserId());
		order.setProductId(orderRequestDto.getProductId());
		purchaseOrderRepo.save(order);

		event.setOrderStatus(OrderStatus.ORDER_CREATED);
		event.setOredrRequestDto(orderRequestDto);

		this.kafkaTemplate.send("orderApp", event);
		System.out.println("produce successfully" + event);
		PurchaseOrder save = purchaseOrderRepo.save(order);
		System.out.println(save.toString() + "   ========================================");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("order cancelled");
		order.setOrderStatus(OrderStatus.ORDER_CANCELLED);

		purchaseOrderRepo.save(order);
	}
	
}

@KafkaListener(topics = "paymentApp", groupId = "orders-group")
public PaymentStatus updateOrder(String paymentEvent) throws JsonMappingException, JsonProcessingException{
	 System.out.println("Recieved paymentEvent" + paymentEvent);
    PaymentEvent paymentEvents = new ObjectMapper().readValue(paymentEvent, PaymentEvent.class);
	PaymentStatus paymentStatus = paymentEvents.getPaymentStatus();
	OrderRequestDto orderRequestDto = paymentEvents.getOrderRequestDto();
	
	if(purchaseOrderRepo.findById(orderRequestDto.getOrderId()).isPresent()) {
		System.out.println(orderRequestDto.getOrderId()+"========================================++++++++++");
		Optional<PurchaseOrder> order = purchaseOrderRepo.findById(orderRequestDto.getOrderId());
		PurchaseOrder order1=order.get();
		order1.setPaymentStatus(paymentStatus);
		purchaseOrderRepo.save(order1);
	}
	System.out.println("==============================================="+paymentStatus);
   return paymentStatus;
  }


@KafkaListener(topics = "reversed-orders", groupId = "orders-group")
public void updatePaymentOrder(String event) {

    try {
        OrderEvent orderEvent = new ObjectMapper().readValue(event, OrderEvent.class);
     
System.out.println("reverse order received"+orderEvent);
        Optional<PurchaseOrder> order = this.purchaseOrderRepo.findById(orderEvent.getOredrRequestDto().getOrderId());

        order.ifPresent(o -> {
            o.setOrderStatus(OrderStatus.ORDER_CANCELLED);
			// changes
            o.setPaymentStatus(PaymentStatus.PAYMENT_FAILED);
           
            this.purchaseOrderRepo.save(o);
        });
    } catch (Exception e) {

        e.printStackTrace();
    }

}


public List<PurchaseOrder> getAllOrders(){
	return purchaseOrderRepo.findAll();
}
}
