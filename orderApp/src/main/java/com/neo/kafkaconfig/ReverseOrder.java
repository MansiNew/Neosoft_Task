package com.neo.kafkaconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.dto.OrderRequestDto;
import com.neo.event.OrderEvent;
import com.neo.event.OrderStatus;
import com.neo.event.PaymentEvent;
import com.neo.event.PaymentStatus;
import com.neo.model.PurchaseOrder;
import com.neo.repo.PurchaseOrderRepo;

//@Component
@Service
public class ReverseOrder {

	@Autowired
    private PurchaseOrderRepo orderRepo;
 
    @KafkaListener(topics = "reversed-orders", groupId = "orders-group")
    public void reverseOrder(String event) {
 
        try {
            OrderEvent orderEvent = new ObjectMapper().readValue(event, OrderEvent.class);
           PaymentEvent paymentEvent = new ObjectMapper().readValue(event,PaymentEvent.class);
 System.out.println("reverse order received"+orderEvent);
            Optional<PurchaseOrder> order = this.orderRepo.findById(orderEvent.getOredrRequestDto().getOrderId());
 
            order.ifPresent(o -> {
                o.setOrderStatus(OrderStatus.ORDER_CANCELLED);
                o.setPaymentStatus(paymentEvent.getPaymentStatus());
                this.orderRepo.save(o);
            });
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
    }
    
    
    @KafkaListener(topics = "paymentApp", groupId = "orders-group")
    public PaymentStatus updateOrder(String paymentEvent) throws JsonMappingException, JsonProcessingException{
    	 System.out.println("Recieved paymentEvent" + paymentEvent);
        PaymentEvent paymentEvents = new ObjectMapper().readValue(paymentEvent, PaymentEvent.class);
    	PaymentStatus paymentStatus = paymentEvents.getPaymentStatus();
    	OrderRequestDto orderRequestDto = paymentEvents.getOrderRequestDto();
    	
    	if(orderRepo.findById(orderRequestDto.getOrderId()).isPresent()) {
    		System.out.println(orderRequestDto.getOrderId()+"========================================++++++++++");
    		Optional<PurchaseOrder> order = orderRepo.findById(orderRequestDto.getOrderId());
    		PurchaseOrder order1=order.get();
    		order1.setPaymentStatus(paymentStatus);
    		orderRepo.save(order1);
    	}
    	System.out.println("==============================================="+paymentStatus);
       return paymentStatus;
       
    }

}

