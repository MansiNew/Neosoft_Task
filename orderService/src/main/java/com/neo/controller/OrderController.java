package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.OrderRequestDto;
import com.neo.exception.OrderAlreadyExistException;
import com.neo.model.PurchaseOrder;
import com.neo.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping("/createOrder")
	public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequestDto) throws OrderAlreadyExistException {
		return orderService.createOrder(orderRequestDto);
	}
	
@GetMapping("/findAllOrder")
	public List<PurchaseOrder> getAllOrders() {
		return orderService.getAllOrders();
	}


}
