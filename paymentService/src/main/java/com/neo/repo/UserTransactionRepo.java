package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.neo.model.UserTransaction;

public interface UserTransactionRepo extends JpaRepository <UserTransaction,Integer> {

}
