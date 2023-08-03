package com.neo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neo.config.HibernateConfig;
import com.neo.model.Employee;
import com.neo.model.User;

@Repository
public class UserDao {
	 public void createUser(User user) {
	    	
		   Transaction transaction=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			session.save(user);
			//session.detach(user);
			transaction.commit();
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
	    }
	
	 public List<User> findAllUser() {
		    try {
		    	return HibernateConfig.getSessionFactory().openSession()
		        .createQuery("FROM User")
		        .getResultList(); 
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
	 public User findUserById(Long uId) {
		  try {
		    	return HibernateConfig.getSessionFactory().openSession()
		       .get(User.class, uId);
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    }	 
	 }
	
	 public void deleteUser(Long uId) {
		 Transaction transaction=null;
		User user=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			
			user = session.get(User.class, uId);
			session.delete(user);
			transaction.commit();
		
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
		  
	 }
	
	 public void updateUser(User user) {
	    	
		   Transaction transaction=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			session.saveOrUpdate(user);
			transaction.commit();
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
	    }	 
}
