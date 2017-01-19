/*
 * 
 */
package action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import utils.HibernateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TestRoutesAction.
 */
public class TestRoutesAction {

	/** The routes action. */
	private RoutesAction routesAction;
	
	/**
	 * Initialize hibernate.
	 */
	@Before
	public void initializeHibernate(){
		HibernateUtils.start();
	}
	
	/**
	 * Inits the routes action.
	 */
	@Before
	public void initRoutesAction(){
		routesAction = new RoutesAction();
	}
	
	/**
	 * Test list.
	 */
	@Test
	public void testList() {
		assertEquals("success", routesAction.list());
	}
}
