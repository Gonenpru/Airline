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

public class TestLoginAction {

	private ActionContext actionContext;
	LoginAction loginAction;
	
	@Before
	public void pepareForCorrectTest() {
		actionContext = Mockito.mock(ActionContext.class);
		Mockito.when(actionContext.getSession()).thenReturn(new HashMap<>());
		loginAction = Mockito.spy(new LoginAction());
		ActionContext.setContext(actionContext);
	}
	
	@Before
	public void initializeHibernate(){
		HibernateUtils.start();
		loginAction = new LoginAction();
	}

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
	
	@After
	public void finishTheTesting() {
		this.setActionContext(null);
	}
	
	public void setActionContext(final ActionContext actionContext) {
		this.actionContext = actionContext;
	}
}
