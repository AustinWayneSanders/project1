package com.austin.projectOne.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.austin.projectOne.model.Employee;

public class EmployeeDAO {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	public static long findByCredentials(String email, String password) {
		session = connect();
		session.beginTransaction();
		//String sql = "SELECT * FROM employee WHERE email = "+email+" AND password = "+password+";";
		Query query = session.createQuery("select count(*) from Employee where email = '"+email+"' and password = '"+password+"'");//+" and password = "+password).list();
		System.out.print(query);
		long count = (long) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		close();
		return count;
	}
	
	public static List<Employee> findAll() {
		session = connect();
		session.beginTransaction();
		List<Employee> employees = session.createQuery("FROM Employee").list();
		session.getTransaction().commit();
		session.close();
		close();
		return employees;
	}

	public static Employee findById(int id) {
		session = connect();
		session.beginTransaction();
		Employee employee = session.find(Employee.class, id);
		session.getTransaction().commit();
		session.close();
		close();
		return employee;
	}

	public static void save(Employee employee) {
		session = connect();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		close();
	}

	public static void update(Employee employee) {
		session = connect();
		session.beginTransaction();	
		session.update(employee);
		session.getTransaction().commit();
		session.close();
		close();
	}

	public static void delete(int id) {
		session = connect();
		session.beginTransaction();
		Employee employee = session.find(Employee.class, id);
		session.remove(employee);
		session.getTransaction().commit();
		session.close();
		close();
	}

	public static Session connect() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		// configures settings from hibernate.cfg.xml
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}

		return sessionFactory.openSession();
	}

	public static void close() {
		try {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}