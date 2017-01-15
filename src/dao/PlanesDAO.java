package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import db_items.Planes;
import utils.HibernateUtils;

public class PlanesDAO extends HibernateUtils{

	public Planes add(Planes plane){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(plane);
		session.getTransaction().commit();
		return plane;
	}
	
	public Planes delete(int id){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Planes plane = (Planes) session.load(Planes.class, id);
		if (plane != null){
			session.delete(plane);
		}
		session.getTransaction().commit();
		return plane;
	}
	
	@SuppressWarnings("unchecked")
	public List<Planes> list(){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Planes> planes = null;
		try {
			planes = (List<Planes>) session.createQuery("from Planes").list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		if (!tx.getStatus().equals(TransactionStatus.ACTIVE)) {
			tx.commit();
		}
		return planes;
	}
}
