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
 * The Class TestPlanesAction.
 */
public class TestPlanesAction {
	
	/** The planes action. */
	private PlanesAction planesAction;

	/**
	 * Initialize hibernate.
	 */
	@Before
	public void initializeHibernate(){
		HibernateUtils.start();
	}
	
	/**
	 * Inits the planes action.
	 */
	@Before
	public void initPlanesAction(){
		planesAction = new PlanesAction();
	}
	
	/**
	 * Test execute.
	 */
	@Test
	public void testExecute() {
		assertEquals("success", planesAction.execute());
	}

}
