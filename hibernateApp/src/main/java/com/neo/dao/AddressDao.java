package com.neo.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neo.config.HibernateConfig;
import com.neo.model.Address;
import com.neo.model.AddressCompositeKey;
import com.neo.model.Employee;

@Repository
public class AddressDao {
	
	 public void createAddress(Address address) {
	    	
		   Transaction transaction=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			session.save(address);
			transaction.commit();
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
	    }
	 
	 public List<Address> findAllAddress() {
		    try {
		    	return HibernateConfig.getSessionFactory().openSession()
		        .createQuery("FROM Address")
		        .getResultList(); 
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
	/* public Address findAddressById(Long addId) {
		  try {
		    	
		    	Address address= HibernateConfig.getSessionFactory().openSession()
			       .get(Address.class, addId);
		    	
		    			AddressCompositeKey a=	new AddressCompositeKey(address.getCity(),address.getCountry(),address.getState());
		    			Address compositeAddress =(Address) HibernateConfig.getSessionFactory().openSession().get(Address.class, a);
			       	return compositeAddress;
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    }	 
	 }*/
}
