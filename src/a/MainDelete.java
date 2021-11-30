package a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Professor.class)
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	
	public void deleteProfessor(int profId) {
		try {
			session.beginTransaction();
			
			Professor professor = session.get(Professor.class, profId);
			
			session.delete(professor);
			
			session.getTransaction().commit();
		} finally {
			
		}
	}
	
	public void deleteStudent(int studId) {
		session.beginTransaction();
		
		Student student = session.get(Student.class, studId);
		
		session.delete(student);
		
		session.getTransaction().commit();
	}
}
