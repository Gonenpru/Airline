package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import db_items.PlaneModels;
import utils.HibernateUtils;

public class PlaneModelsDAO extends HibernateUtils{

	public PlaneModels add(PlaneModels planeModels) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(planeModels);
		tx.commit();
		return planeModels;
	}
	
	public PlaneModels delete(int id){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		PlaneModels planeModel = (PlaneModels) session.load(PlaneModels.class, id);
		if (planeModel != null){
			session.delete(planeModel);
		}
		session.getTransaction().commit();
		return planeModel;
	}
	
	@SuppressWarnings("unchecked")
	public List<PlaneModels> list(){
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<PlaneModels> planeModels = null;
		try {
			planeModels = (List<PlaneModels>) session.createQuery("from PlaneModels").list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
		if (!tx.getStatus().equals(TransactionStatus.ACTIVE)) {
			//tx.commit();
		}
		return planeModels;
	}
	
}
