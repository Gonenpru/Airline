/*
 * 
 */
package action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AirlinesDao;
import db_items.Airlines;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginAction.
 */
public class LoginAction extends ActionSupport {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The airlinesdao. */
	AirlinesDao airlinesdao;
	
	/** The airlines. */
	List<Airlines> airlines;

	/** The email. */
	private String email;
	
	/** The password. */
	private String password;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String execute() throws Exception {
		airlinesdao = new AirlinesDao();
		airlines = airlinesdao.list();
		
		for(int i=0; i < airlines.size() ; i++){
			if(airlines.get(i).getEmail().equals(email) && airlines.get(i).getPassword().equals(password)){
				Map session = ActionContext.getContext().getSession();
				session.put("logined","true");
				session.put("context", new Date());
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
  /**
	 * Index goes to the main page
	 *
	 * @return succes text. Just for redirection
	 */
  public String index() {
		return SUCCESS;
	}
  
	/**
	 * Logout.
	 *
	 * @return the string
	 * @throws Exception the exception
	 */
	@SuppressWarnings("rawtypes")
	public String logout() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.remove("logined");
		session.remove("context");
		return SUCCESS;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param passwd the new password
	 */
	public void setPassword(String passwd) {
		this.password = passwd;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
