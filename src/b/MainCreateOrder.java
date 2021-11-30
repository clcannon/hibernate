package b;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import a.Professor;
import a.Student;

public class MainCreateOrder {
	public void createOrder(String customerName, Date date, List<Product> products) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Professor.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Order o = new Order();
			o.setCustomerName(null);
			o.setDate(date);
			o.setProducts(products);
			
			session.save(o);
		} finally {
			session.close();
			factory.close();
		}
	}

}
