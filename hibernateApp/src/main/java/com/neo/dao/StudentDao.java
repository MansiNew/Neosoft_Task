package com.neo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neo.config.HibernateConfig;
import com.neo.model.Employee;
import com.neo.model.Student;

@Repository
public class StudentDao {
	public void createStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void updateStudent(Student student) {

		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
