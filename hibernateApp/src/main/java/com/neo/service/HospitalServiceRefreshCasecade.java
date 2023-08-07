package com.neo.service;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.config.HibernateConfig;
import com.neo.dao.HospitalDao;
import com.neo.model.Hospital;

@Service
public class HospitalServiceRefreshCasecade {
	@Autowired
	private HospitalDao hospitalDao;
	@Transactional
	 public void refreshHospital(Hospital hospital) {
	    hospitalDao.refershHospital(hospital);
	    }
	 

}
