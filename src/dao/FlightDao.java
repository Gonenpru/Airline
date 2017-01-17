package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db_items.Flights;
import utils.HibernateUtils;

public class FlightDao extends HibernateUtils{
	
	public Flights add(Flights flights) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(flights);
		tx.commit();
		return flights;
	}
	
	public Flights delete(int id){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Flights flights = (Flights) session.load(Flights.class, id);
		if (flights != null){
			session.delete(flights);
		}
		tx.commit();
		return flights;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flights> list(){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<Flights> flights = null;
		try {
			flights = (List<Flights>) session.createQuery("from Flights").list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
		return flights;
	}
	
}
