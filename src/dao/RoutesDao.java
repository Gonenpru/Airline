/*
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import db_items.Routes;
import utils.HibernateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class RoutesDao.
 */
public class RoutesDao extends HibernateUtils {
	
	/**
	 * List specific.
	 *
	 * @param id the id
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Routes> listSpecific(int id){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<Routes> list = null;
		try {
			Query query = session.createSQLQuery("select * from Routes where airline_id = :airline_id").setInteger("airline_id", id);
			list = query.list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
		return list;
	}
	
	/**
	 * List.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Routes> list(){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<Routes> routes = null;
		try {
			routes = (List<Routes>) session.createQuery("from Routes order by id asc").list();
			System.out.println(routes);
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
		return routes;
	}

}
	