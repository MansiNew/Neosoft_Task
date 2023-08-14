package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.UserBalance;

public interface UserBalanceRepo extends JpaRepository<UserBalance,Integer>{

}
