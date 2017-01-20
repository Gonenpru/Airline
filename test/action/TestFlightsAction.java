/*
 * 
 */
package action;
import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import action.FlightsAction;
import dao.FlightDao;
import db_items.Flights;
import utils.HibernateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TestFlightsAction.
 */
public class TestFlightsAction {
	
	/** The flights action. */
	private FlightsAction flightsAction;
	
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
		flightDao = new FlightDao();
	}
	
	/**
	 * Inits the flights action.
	 */
	@Before
	public void initFlightsAction(){
		flightsAction = new FlightsAction();
	}
	
	/**
	 * Test execute function.
	 */
	@Test
	public void testExecuteFunction() {	
		assertEquals("success", flightsAction.execute());
	}
	
	/**
	 * Test return list from dao.
	 */
	@Test
	public void testReturnListFromDao() {
		assertEquals("success", flightsAction.list());
	}

	/**
	 * Test add function.
	 */
	@Test
	public void testAddFunction(){
		Flights f = new Flights(10, 0, 0, 0, 0, "00:00", "00:00", new Timestamp(0));
		f.setD_Departure(new Date());
		f.setD_Time("00:00");
		flightsAction.setFlights(f);
		flightsAction.execute();
		assertEquals("success", flightsAction.add());
		flightDao.delete(flightsAction.getFlights().getId());
	}
	
	/**
	 * Test update function.
	 */
	@Test
	public void testUpdateFunction() {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Flights f = new Flights(10, 0, 0, 0, 0, "00:00", "00:00", new Timestamp(0));
		f.setD_Departure(new Date());
		f.setD_Time("00:00");
		flightsAction.setFlights(f);
		flightsAction.add();
		f.setGate_id(3);
		flightsAction.update();
		
		Query query = session.createSQLQuery("select gate_id from Flights where id = :flight_id").setInteger("flight_id", flightsAction.getFlights().getId());		
		Object obj = query.list().get(0);
		int id = Integer.parseInt(obj.toString());
		assertEquals("Gate id is the same", flightsAction.getFlights().getGate_id(), id);
		flightDao.delete(flightsAction.getFlights().getId());
	}
}
