package com.neo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neo.config.HibernateConfig;
import com.neo.model.Product;
import com.neo.model.User;

@Repository
public class ProductDao {
	public void detachProduct(Long prId) {
		Transaction transaction = null;
		Product product = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			product = session.get(Product.class, prId);
			session.detach(product);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}
}
