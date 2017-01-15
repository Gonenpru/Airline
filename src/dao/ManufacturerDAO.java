package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import db_items.Manufacturers;
import utils.HibernateUtils;

public class ManufacturerDAO extends HibernateUtils{

	public Manufacturers add(Manufacturers manufacturer) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(manufacturer);
		tx.commit();
		return manufacturer;
	}
	
	public Manufacturers delete(int id){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Manufacturers manufacturer = (Manufacturers) session.load(Manufacturers.class, id);
		if (manufacturer != null){
			session.delete(manufacturer);
		}
		tx.commit();
		return manufacturer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Manufacturers> list(){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Manufacturers> manufacturers = null;
		try {
			manufacturers = (List<Manufacturers>) session.createQuery("from Manufacturers").list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
		if (!tx.getStatus().equals(TransactionStatus.ACTIVE)) {
			//tx.commit();
		}
		return manufacturers;
	}
}
