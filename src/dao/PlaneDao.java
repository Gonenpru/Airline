/*
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import db_items.Planes;
import utils.HibernateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class PlaneDao.
 */
public class PlaneDao extends HibernateUtils {

	/** The hours. */
	private int hours;
	
	/** The minutes. */
	private int minutes;

	/**
	 * List.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Planes> list() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<Planes> planes = null;
		try {
			planes = (List<Planes>) session.createQuery("from Planes order by id asc").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return planes;
	}

	/**
	 * Gets the plane name.
	 *
	 * @param id the id
	 * @return the plane name
	 */
	public String getPlaneName(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select planeName(:plane_id)").setInteger("plane_id", id);
		String name = String.valueOf(query.list());
		return deleteBrackets(name);
	}

	/**
	 * Gets the plane hours.
	 *
	 * @param id the id
	 * @return the plane hours
	 */
	@SuppressWarnings("unchecked")
	public String getPlaneHours(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select duration from Flights where plane_id = :plane_id").setInteger("plane_id", id);
		List<Object> list = query.list();
		String totHours = getTotHours(list);
		return totHours;
	}

	/**
	 * Gets the tot hours.
	 *
	 * @param list the list
	 * @return the tot hours
	 */
	private String getTotHours(List<Object> list) {
		hours = 0;
		minutes = 0;
		for (Object obj : list) {
			String a = obj.toString();
			String[] b = a.split(":");
			hours += Integer.parseInt(b[0]);
			minutes += Integer.parseInt(b[1]);
			if (minutes > 59) {
				hours++;
				minutes -= 60;
			}
		}
		return (((hours < 10) ? "0" + hours : hours) + ":" + ((minutes < 10) ? "0" + minutes : minutes));
	}

	/**
	 * Gets the plane flights.
	 *
	 * @param id the id
	 * @return the plane flights
	 */
	public int getPlaneFlights(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select planeFlights(:plane_id)").setInteger("plane_id", id);
		Object obj = query.list().get(0);
		int total = Integer.parseInt(obj.toString());
		return total;
	}

	/**
	 * Delete brackets.
	 *
	 * @param str the str
	 * @return the string
	 */
	public String deleteBrackets(String str) {
		return str.substring(1, str.length() - 1);
	}
}
