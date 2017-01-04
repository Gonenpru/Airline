package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import db_items.Planes;
import utils.HibernateUtils;

public class PlanesDAO extends HibernateUtils{

	public Planes add(Planes plane){
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(plane);
		session.getTransaction().commit();
		return plane;
	}
	
	public Planes delete(Long id){
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
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
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Planes> planes = null;
		try {
			planes = (List<Planes>) session.createQuery("from Planes").list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return planes;
	}
}
