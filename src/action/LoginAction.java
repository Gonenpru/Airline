package action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.AirlinesDao;
import db_items.Airlines;



public class LoginAction extends ActionSupport {
	
	AirlinesDao airlinesdao;
	List<Airlines> airlines;

	private String email;
	private String password;

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
