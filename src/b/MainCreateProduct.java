package b;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import a.Professor;
import a.Student;

public class MainCreateProduct {
	public void createOrder(String name, List<Order> orders) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Professor.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Product p = new Product();
			p.setName(name);
			p.setOrders(orders);
			
			session.save(p);
		} finally {
			session.close();
			factory.close();
		}
	}
}
