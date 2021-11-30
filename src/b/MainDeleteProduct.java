package b;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import a.Professor;
import a.Student;

public class MainDeleteProduct {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Professor.class)
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	public void deleteOrder(int productId) {
		try {
			session.beginTransaction();
			
			Product product = session.get(Product.class, productId);
			
			session.delete(product);
			
			session.getTransaction().commit();
		} finally {
			
		}
	}
}
