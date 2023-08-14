package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.PurchaseOrder;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder,Integer>{

}
