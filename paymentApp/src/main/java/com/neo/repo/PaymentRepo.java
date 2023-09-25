package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {

}
