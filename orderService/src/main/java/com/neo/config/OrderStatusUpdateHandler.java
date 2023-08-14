package com.neo.config;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dto.OrderRequestDto;
import com.neo.event.OrderStatus;
import com.neo.event.PaymentStatus;
import com.neo.model.PurchaseOrder;
import com.neo.repo.PurchaseOrderRepo;

@Configuration
public class OrderStatusUpdateHandler {
@Autowired
	private PurchaseOrderRepo purchaseOrderRepo;

@Autowired
private OrderStatusPublisher orderStatusPublisher;

@Transactional
public void updateOrder(int id,Consumer<PurchaseOrder> consumer) {
	purchaseOrderRepo.findById(id).ifPresent(consumer.andThen(this::updateOrder));
	
}
public void updateOrder(PurchaseOrder order) {
	boolean isPaymentSuccess = PaymentStatus.PAYMENT_SUCCESS.equals(order.getPaymentStatus());
	OrderStatus orderStatus=isPaymentSuccess?OrderStatus.ORDER_COMPLETED:OrderStatus.ORDER_CANCELLED;
	order.setOrderStatus(orderStatus);
	if(!isPaymentSuccess) {
		orderStatusPublisher.publishOrderEvent(OrderToDtoConversion(order), orderStatus);
	}
	
}

public OrderRequestDto OrderToDtoConversion(PurchaseOrder order) {
	OrderRequestDto orderRequestDto=new OrderRequestDto();
	orderRequestDto.setOrderId(order.getId());
	orderRequestDto.setProductId(order.getProductId());
	orderRequestDto.setUserId(order.getUserId());
	orderRequestDto.setAmount(order.getPrice());
	return orderRequestDto;
}
}
