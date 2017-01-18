package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import db_items.Planes;
import utils.HibernateUtils;

public class PlaneDao extends HibernateUtils {

	private int hours;
	private int minutes;

	@SuppressWarnings("unchecked")
	public List<Planes> list() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		List<Planes> planes = null;
		try {
			planes = (List<Planes>) session.createQuery("from Planes").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return planes;
	}

	public String getPlaneName(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select planeName(:plane_id)").setInteger("plane_id", id);
		String name = String.valueOf(query.list());
		return deleteBrackets(name);
	}

	public String getPlaneHours(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select planeHours(:plane_id)").setInteger("plane_id", id);
		List<Object> list = query.list();
		String totHours = getTotHours(list);
		return totHours;
	}

	private String getTotHours(List<Object> list) {
		// TODO Auto-generated method stub
		String ret = "";
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

	public int getPlaneFlights(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select planeFlights(:plane_id)").setInteger("plane_id", id);
		String val = String.valueOf(query.list());
		int total = Integer.parseInt(val);
		return total;
	}

	public String deleteBrackets(String str) {
		return str.substring(1, str.length() - 1);
	}
}
