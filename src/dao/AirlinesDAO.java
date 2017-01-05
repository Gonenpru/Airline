package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import db_items.Airlines;
import utils.HibernateUtils;

public class AirlinesDAO extends HibernateUtils{
	
	public Airlines add(Airlines airline){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(airline);
		tx.commit();
		return airline;
	}
	
	public Airlines delete(int id){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Airlines airline = (Airlines) session.load(Airlines.class, id);
		if (airline != null){
			session.delete(airline);
		}
		session.getTransaction().commit();
		return airline;
	}
	
	@SuppressWarnings("unchecked")
	public List<Airlines> list(){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Airlines> airlines = null;
		try {
			airlines = (List<Airlines>) session.createQuery("from Airlines").list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		if (!tx.getStatus().equals(TransactionStatus.ACTIVE)) {
			tx.commit();
		}
		return airlines;
	}
}
