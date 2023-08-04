package com.neo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neo.config.HibernateConfig;
import com.neo.model.Employee;
import com.neo.model.Hospital;
import com.neo.model.Person;

@Repository
public class HospitalDao {
	 public void refershHospital(Hospital hospital) {
	    	
		   Transaction transaction=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			session.refresh(hospital);
			transaction.commit();
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
	    }
	}
