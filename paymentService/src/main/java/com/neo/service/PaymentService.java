package com.neo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dto.OrderRequestDto;
import com.neo.dto.PaymentRequestDto;
import com.neo.event.OrderEvent;
import com.neo.event.PaymentEvent;
import com.neo.event.PaymentStatus;
import com.neo.model.UserTransaction;
import com.neo.repo.UserBalanceRepo;
import com.neo.repo.UserTransactionRepo;

@Service
public class PaymentService {

	@Autowired
	private UserBalanceRepo userBalanceRepo;
	
	@Autowired
	private UserTransactionRepo userTransactionRepo;
	
	@Transactional//commit
	public PaymentEvent newOrderEvent(OrderEvent orderEvent) {
		// getuserid ,check balance availability,if balance sufficient payment
		// completed,otherwise cancel orderevnt and update amount in db
		OrderRequestDto oredrRequestDto = orderEvent.getOredrRequestDto();
		// need paymentrequestdto to build payment request
		PaymentRequestDto paymentRequestDto = new PaymentRequestDto(oredrRequestDto.getOrderId(),
				oredrRequestDto.getUserId(), oredrRequestDto.getAmount());
		PaymentEvent paymentEvent = userBalanceRepo.findById(oredrRequestDto.getUserId())
				.filter(userBalance -> userBalance.getPrice() > oredrRequestDto.getAmount())
				.map(userBalance -> {
					userBalance.setPrice(userBalance.getPrice() - oredrRequestDto.getAmount());
					userTransactionRepo.save(new UserTransaction(oredrRequestDto.getOrderId(),oredrRequestDto.getUserId(), oredrRequestDto.getAmount()));
					return new PaymentEvent(paymentRequestDto, PaymentStatus.PAYMENT_SUCCESS);
				}).orElse(new PaymentEvent(paymentRequestDto,PaymentStatus.PAYMENT_FAILED));
		return paymentEvent;
	}

	@Transactional // rollback
	public void cancelOrderEvent(OrderEvent orderEvent) {
		userTransactionRepo.findById(orderEvent.getOredrRequestDto().getOrderId()).ifPresent(userTransaction -> {
			userTransactionRepo.delete(userTransaction);
			userTransactionRepo.findById(userTransaction.getUserId()).ifPresent(
					userBalance -> userBalance.setAmount(userBalance.getAmount() + userTransaction.getAmount()));
		});

	}

}
