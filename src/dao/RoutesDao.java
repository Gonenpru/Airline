package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import db_items.Flights;
import db_items.Routes;
import utils.HibernateUtils;

public class RoutesDao extends HibernateUtils {
	
	@SuppressWarnings("unchecked")
	public List<Routes> list(int id){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<Routes> routes = null;
		try {
			//Query query = session.createSQLQuery("select * from routes where airline_id = :id").setInteger("id", id);

			routes = (List<Routes>) session.createQuery("from Routes").list();
			//routes = (List<Routes>) query.list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
		return routes;
	}

}
