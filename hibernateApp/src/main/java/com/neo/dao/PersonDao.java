package com.neo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neo.config.HibernateConfig;
import com.neo.model.Employee;
import com.neo.model.Person;

@Repository
public class PersonDao {
	public void updatePerson(Person person) {

		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			System.out.println("hello merge");
			session.merge(person);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("hello merge");
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void createPerson(Person person) {

		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(person);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
