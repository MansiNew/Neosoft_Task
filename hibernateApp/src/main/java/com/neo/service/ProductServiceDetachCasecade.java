package com.neo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.ProductDao;
@Service
public class ProductServiceDetachCasecade {
	@Autowired
	ProductDao productDao;
	@Transactional
	 public void detachProduct(Long prId) {
		productDao.detachProduct(prId);
	}
}
