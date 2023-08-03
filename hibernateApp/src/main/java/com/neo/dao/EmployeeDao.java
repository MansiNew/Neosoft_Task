package com.neo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.neo.config.HibernateConfig;
import com.neo.model.Employee;

@Repository
public class EmployeeDao {
	 public void createEmployee(Employee employee) {
	    	
		   Transaction transaction=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			session.save(employee);
			transaction.commit();
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
	    }
	/* public List<Employee> findAllEmployee(){
		 Transaction transaction=null;
			List<Employee> empList=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			Query<Employee> createQuery = session.createQuery("from Emlployee",Employee.class);
			 empList = createQuery.list();
			
			transaction.commit();
			return empList;
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
		   return empList;
	 }*/
	 public List<Employee> findAllEmployee() {
		    try {
		    	return HibernateConfig.getSessionFactory().openSession()
		        .createQuery("FROM Employee")
		        .getResultList(); 
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
	 public Employee findEmployeeById(Long empId) {
		  try {
		    	return HibernateConfig.getSessionFactory().openSession()
		       .get(Employee.class, empId);
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    }	 
	 }
	
	 public void deleteEmployee(Long empId) {
		 Transaction transaction=null;
			Employee employee=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			
			employee = session.get(Employee.class, empId);
			session.delete(employee);
			transaction.commit();
		
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
		  
	 }
	
	 public void updateEmployee(Employee employee) {
	    	
		   Transaction transaction=null;
		   try(Session session=HibernateConfig.getSessionFactory().openSession()){
			 transaction=session.beginTransaction()  ; 
			session.saveOrUpdate(employee);
			transaction.commit();
		   }catch(Exception e) {
			   if(transaction!=null) {
				   transaction.rollback();
			   }
		   }
	    }	
	 //criteria queries
	 public List<Employee> findAllEmployeeByCriteriaQuery(){
		 try {
		    	return HibernateConfig.getSessionFactory().openSession()
		       .createCriteria(Employee.class).list();
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    }
	 }
	 public List<Employee> findEmployeeWhoseSalaryIsHigherThan2000(){
		 try {
		    	return HibernateConfig.getSessionFactory().openSession()
		       .createCriteria(Employee.class).add(Restrictions.gt("salary", 2000.0)).list();
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    } 
		 
	 }
	 public List<Employee> findEmployeeNameStartsWithapt(){
		 try {
		    	return HibernateConfig.getSessionFactory().openSession()
		       .createCriteria(Employee.class).add(Restrictions.ilike("name", "apt%")).list();
		    }
		    catch (Exception e) {
		        throw new RuntimeException(e);
		    } 
		 
	 }
}
