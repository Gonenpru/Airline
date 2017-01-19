package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import db_items.Airlines;
import utils.HibernateUtils;

public class AirlinesDao extends HibernateUtils {
	
	@SuppressWarnings("unchecked")
	public List<Airlines> list(){
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<Airlines> airlines = null;
		try {
			airlines = (List<Airlines>) session.createQuery("from Airlines order by id asc").list();
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}	
		return airlines;
	}

}

