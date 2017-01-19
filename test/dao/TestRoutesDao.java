package dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import db_items.Routes;
import utils.HibernateUtils;

public class TestRoutesDao {

	private RoutesDao routesDao;
	private Session session;
	
	@Before
	public void initializeHibernate(){
		HibernateUtils.start();
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
	}
	
	@Before
	public void initRoutesDao(){
		routesDao = new RoutesDao();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRoutesDaoList() {
		
		List<Routes> routesList_1 = routesDao.list();
		List<Routes> routesList_2 = (List<Routes>) session.createQuery("from Routes order by id asc").list();
		
		// COMPARE ALL THE LIST 
		for (int i = 0; i < routesList_1.size(); i++){
			assertEquals(routesList_1.get(i).getId(), routesList_2.get(i).getId());
		}
	}
}
