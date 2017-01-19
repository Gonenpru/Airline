/*
 * 
 */
package dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import db_items.Airlines;
import utils.HibernateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TestAirlinesDao.
 */
public class TestAirlinesDao {
	
	/** The airlines dao. */
	private AirlinesDao airlinesDao;
	
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
	 * Inits the airlines dao.
	 */
	@Before
	public void initAirlinesDao(){
		airlinesDao = new AirlinesDao();
	}
	
	/**
	 * Test list.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testList() {
		
		List<Airlines> airlines_1 = airlinesDao.list();
		List<Airlines> airlines_2 = (List<Airlines>) session.createQuery("from Airlines").list();
		
		// COMPARE ALL THE LIST 
		for (int i = 0; i < airlines_1.size(); i++){
			assertEquals(airlines_1.get(i).getId(), airlines_2.get(i).getId());
		}
	}
}
