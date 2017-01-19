/*
 * 
 */
package login;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.opensymphony.xwork2.ActionContext;

import action.LoginAction;
import utils.HibernateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TestLoginAction.
 */
public class TestLoginAction {

	/** The action context. */
	private ActionContext actionContext;
	
	/** The login action. */
	LoginAction loginAction;
	
	/**
	 * Pepare for correct test.
	 */
	@Before
	public void pepareForCorrectTest() {
		actionContext = Mockito.mock(ActionContext.class);
		Mockito.when(actionContext.getSession()).thenReturn(new HashMap<>());
		loginAction = Mockito.spy(new LoginAction());
		ActionContext.setContext(actionContext);
	}
	
	/**
	 * Initialize hibernate.
	 */
	@Before
	public void initializeHibernate(){
		HibernateUtils.start();
		loginAction = new LoginAction();
	}

	/**
	 * Test log in ok.
	 */
	@Test
	public void testLogInOk() {
		
		loginAction.setEmail("Emirates@gmail.com");
		loginAction.setPassword("1234");
		try {
			assertEquals("success", loginAction.execute());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test log in not ok.
	 */
	@Test
	public void testLogInNotOk() {
		
		loginAction.setEmail("Emirates@gmail.com");
		loginAction.setPassword("0000");
		try {
			assertEquals("error", loginAction.execute());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test log out ok.
	 */
	@Test
	public void testLogOutOk() {
		
		loginAction.setEmail("Emirates@gmail.com");
		loginAction.setPassword("1234");
		try {
			assertEquals("success", loginAction.logout());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Finish the testing.
	 */
	@After
	public void finishTheTesting() {
		this.setActionContext(null);
	}
	
	/**
	 * Sets the action context.
	 *
	 * @param actionContext the new action context
	 */
	public void setActionContext(final ActionContext actionContext) {
		this.actionContext = actionContext;
	}
}
