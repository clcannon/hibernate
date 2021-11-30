package a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
	public void createMain(String name, String address, String profName, String officeNumber, String researchArea) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Professor.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student s = new Student();
			s.setName(name);
			s.setAddress(address);
			
			Professor p = new Professor();
			p.setOfficeNumber(officeNumber);
			p.setResearchArea(researchArea);
			p.setStudent(s);
			
			s.setProfessor(p);
			
			session.save(p);
			session.save(s);
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
