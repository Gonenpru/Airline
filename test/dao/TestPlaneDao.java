/*
 * 
 */
package dao;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import db_items.Planes;
import utils.HibernateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TestPlaneDao.
 */
public class TestPlaneDao {

	/** The plane dao. */
	private PlaneDao planeDao;
	
	/** The session. */
	private Session session;
	
	/**
	 * Initialize hibernate.
	 */
	@Before
	public void initializeHibernate(){
		HibernateUtils.start();
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
	}
	
	/**
	 * Inits the plane dao.
	 */
	@Before
	public void initPlaneDao(){
		planeDao = new PlaneDao();
	}
	
	/**
	 * Test plane dao list.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPlaneDaoList() {
		
		List<Planes> planesList_1 = planeDao.list();
		List<Planes> planesList_2 = (List<Planes>) session.createQuery("from Planes").list();
		
		// COMPARE ALL THE LIST 
		for (int i = 0; i < planesList_1.size(); i++){
			assertEquals(planesList_1.get(i).getId(), planesList_2.get(i).getId());
		}
	}
	
	/**
	 * Test plane dao plane name.
	 */
	@Test
	public void testPlaneDaoPlaneName(){
		String name_1 = planeDao.getPlaneName(1);
		Query query = session.createSQLQuery("select planeName(:plane_id)").setInteger("plane_id", 1);
		String name_2 = String.valueOf(query.list());	
		String fin = planeDao.deleteBrackets(name_2);
		assertEquals(name_1, fin);
	}
	
	/**
	 * Test plane dao plane hours.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPlaneDaoPlaneHours(){
		String hours_1 = planeDao.getPlaneHours(1);
		Query query = session.createSQLQuery("select duration from Flights where plane_id = :plane_id").setInteger("plane_id", 1);
		List<Object> list = query.list();
		
		Class<?> planesDao = null;
		Method meth = null;		
		try{
			planesDao = Class.forName("dao.PlaneDao");
			meth = planesDao.getDeclaredMethod("getTotHours", List.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		meth.setAccessible(true);
		
		try {
			assertEquals(hours_1, meth.invoke(planesDao.newInstance(), list));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Test plane dao plane flights.
	 */
	@Test
	public void testPlaneDaoPlaneFlights(){
		int total_1 = planeDao.getPlaneFlights(1);
		Query query = session.createSQLQuery("select planeFlights(:plane_id)").setInteger("plane_id", 1);
		Object obj = query.list().get(0);
		int total_2 = Integer.parseInt(obj.toString());
		assertEquals(total_1, total_2);
	}
}


















