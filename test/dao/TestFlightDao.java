/*
 * 
 */
package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;


import db_items.Flights;
import utils.HibernateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TestFlightDao.
 */
public class TestFlightDao {

	/** The flight dao. */
	private FlightDao flightDao;
	
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
	 * Inits the flights dao.
	 */
	@Before
	public void initFlightsDao(){
		flightDao = new FlightDao();
	}
	
	/**
	 * Test flights dao list.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testFlightsDaoList() {
		
		List<Flights> flightsList_1 = flightDao.list();
		List<Flights> flightsList_2 = (List<Flights>) session.createQuery("from Flights order by id asc").list();
		
		// COMPARE ALL THE LIST 
		for (int i = 0; i < flightsList_1.size(); i++){
			assertEquals(flightsList_1.get(i).getId(), flightsList_2.get(i).getId());
		}
	}

	/**
	 * Test flights dao add.
	 */
	@Test
	public void testFlightsDaoAdd(){
		Flights flights = new Flights();
		flights.setId(99);
		flights.setBaggage_id(0);
		flights.setGate_id(0);
		flights.setPlane_id(0);
		flights.setRoute_id(0);
		
		flights =  flightDao.add(flights);
		Query query = session.createSQLQuery("select id from Flights where id = :flight_id").setInteger("flight_id", 99);		
		Object obj = query.list().get(0);
		int id = Integer.parseInt(obj.toString());
		assertEquals("Inserting new flight", flights.getId(), id);
		flightDao.delete(99);
	}	
	
	/**
	 * Test flights dao delete.
	 */
	@Test
	public void testFlightsDaoDelete(){
		Flights flights = new Flights();
		flights.setId(99);
		flights.setBaggage_id(0);
		flights.setGate_id(0);
		flights.setPlane_id(0);
		flights.setRoute_id(0);
		flights =  flightDao.add(flights);
		flights =  flightDao.delete(99);
		Query query = session.createSQLQuery("select id from Flights where id = :flight_id").setInteger("flight_id", 99);	
		assertEquals(0, query.list().size());
	}
	
	/**
	 * Test flights dao update.
	 */
	@Test 
	public void testFlightsDaoUpdate(){
		Flights flights = new Flights();
		flights.setId(99);
		flights.setBaggage_id(0);
		flights.setGate_id(0);
		flights.setPlane_id(0);
		flights.setRoute_id(0);
		
		flights =  flightDao.add(flights);
		flights.setBaggage_id(1);
		flights = flightDao.update(flights);
		Query query = session.createSQLQuery("select baggage_id from Flights where id = :flight_id").setInteger("flight_id", 99);	
		Object obj = query.list().get(0);
		int id = Integer.parseInt(obj.toString());
		assertEquals("Updating a flight", flights.getBaggage_id(), id);
		flightDao.delete(99);
	}
}
