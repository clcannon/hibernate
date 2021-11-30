package b;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import a.Professor;
import a.Student;

public class MainDeleteOrder {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Professor.class)
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	public void deleteOrder(int orderId) {
		try {
			session.beginTransaction();
			
			Order order = session.get(Order.class, orderId);
			
			session.delete(order);
			
			session.getTransaction().commit();
		} finally {
			
		}
	}
}
