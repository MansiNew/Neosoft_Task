package com.neo.config;

import java.util.Properties;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.neo.model.Address;
import com.neo.model.Department;
import com.neo.model.Employee;

public class HibernateConfig {
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatePoc");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "password_123");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(Address.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                           } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
	
}
