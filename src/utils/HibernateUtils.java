package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	
	public static void start() {
		sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static void stop() {
		sessionFactory.close();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}