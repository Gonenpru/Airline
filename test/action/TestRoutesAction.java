package action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import utils.HibernateUtils;

public class TestRoutesAction {

	private RoutesAction routesAction;
	
	@Before
	public void initializeHibernate(){
		HibernateUtils.start();
	}
	
	@Before
	public void initRoutesAction(){
		routesAction = new RoutesAction();
	}
	
	@Test
	public void testList() {
		assertEquals("success", routesAction.list());
	}
}
