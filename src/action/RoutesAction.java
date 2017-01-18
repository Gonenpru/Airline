package action;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.RoutesDao;
import db_items.Routes;

public class RoutesAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Routes> routesList;
	private RoutesDao routesDao;
	
	public RoutesAction(){
		routesDao = new RoutesDao();
	}
	
	
	public String list(){
		this.routesList = routesDao.list();
		return SUCCESS;
	}


	public List<Routes> getRoutesList() {
		return routesList;
	}


	public void setRoutesList(List<Routes> routesList) {
		this.routesList = routesList;
	}


}
