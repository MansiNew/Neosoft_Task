package com.neo.config;

import java.util.Properties;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.neo.model.Account;
import com.neo.model.Address;
import com.neo.model.Building;
import com.neo.model.Color;
import com.neo.model.Department;
import com.neo.model.Employee;
import com.neo.model.Hospital;
import com.neo.model.IdentityCard;
import com.neo.model.Person;
import com.neo.model.Product;
import com.neo.model.School;
import com.neo.model.Student;
import com.neo.model.User;

public class HibernateConfig {
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernateTasks");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "password_123");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(Address.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(School.class);
                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(IdentityCard.class);
                configuration.addAnnotatedClass(Hospital.class);
                configuration.addAnnotatedClass(Building.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Color.class);
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
