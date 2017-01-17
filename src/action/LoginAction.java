package action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {

	private String email;
	private String password;

	public String execute() throws Exception {
		if ("admin".equals(email) && "password".equals(password)) {
			//            HttpSession session = ServletActionContext.getRequest().getSession();
			//            session.setAttribute("logined","true");
			//            session.setAttribute("context", new Date());
			// Better is using ActionContext 
			Map session = ActionContext.getContext().getSession();
			session.put("logined","true");
			session.put("context", new Date());
			return SUCCESS;
		}
		return ERROR;
	}

	public String logout() throws Exception {
		//        HttpSession session = ServletActionContext.getRequest().getSession();
		//        session.removeAttribute("logined");
		//        session.removeAttribute("context"); 
		Map session = ActionContext.getContext().getSession();
		session.remove("logined");
		session.remove("context");
		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwd) {
		this.password = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
