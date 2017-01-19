package action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import utils.HibernateUtils;

public class TestPlanesAction {
	private PlanesAction planesAction;

	@Before
	public void initializeHibernate(){
		HibernateUtils.start();
	}
	
	@Before
	public void initPlanesAction(){
		planesAction = new PlanesAction();
	}
	
	@Test
	public void testExecute() {
		assertEquals("success", planesAction.execute());
	}

}
