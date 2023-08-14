package com.neo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.config.OrderStatusPublisher;
import com.neo.dto.OrderRequestDto;
import com.neo.event.OrderStatus;
import com.neo.exception.OrderAlreadyExistException;
import com.neo.model.PurchaseOrder;

import com.neo.repo.PurchaseOrderRepo;

@Service
public class OrderService {
@Autowired
	private  PurchaseOrderRepo purchaseOrderRepo;

@Autowired
private OrderStatusPublisher orderStatusPublisher;

//exceute in single transation
@Transactional
public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) throws OrderAlreadyExistException {

	if (purchaseOrderRepo.findById(orderRequestDto.getOrderId()).isPresent()) {
		throw new OrderAlreadyExistException("order is already exist so you cannot create order for this id");
	}
	
	PurchaseOrder purchaseOrder = orderDtoToPurchaseOrder(orderRequestDto);
	
	PurchaseOrder saveOrder = purchaseOrderRepo.save(purchaseOrder);
	orderStatusPublisher.publishOrderEvent(orderRequestDto, OrderStatus.ORDER_CREATED);
	// produce kafka event with status order created

	return saveOrder;
}

public   PurchaseOrder orderDtoToPurchaseOrder(OrderRequestDto orderRequestDto) {
	PurchaseOrder order=new PurchaseOrder();
	order.setId(orderRequestDto.getOrderId());
	order.setOrderStatus(OrderStatus.ORDER_CREATED);
	order.setPrice(orderRequestDto.getAmount());
	order.setUserId(orderRequestDto.getUserId());
	order.setProductId(orderRequestDto.getProductId());
	 purchaseOrderRepo.save(order);
	System.out.println(order.getPrice()+"===================================");
	return order;
}

public List<PurchaseOrder> getAllOrders(){
	return purchaseOrderRepo.findAll();
}
}
