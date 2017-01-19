/*
 * 
 */
package action;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.RoutesDao;
import db_items.Routes;

// TODO: Auto-generated Javadoc
/**
 * The Class RoutesAction.
 */
public class RoutesAction extends ActionSupport {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The routes list. */
	private List<Routes> routesList;
	
	/** The routes dao. */
	private RoutesDao routesDao;
	
	/**
	 * Instantiates a new routes action.
	 */
	public RoutesAction(){
		routesDao = new RoutesDao();
	}
	
	
	/**
	 * List.
	 *
	 * @return the string
	 */
	public String list(){
		if (routesDao.list() != null){
			this.routesList = routesDao.list();
			return SUCCESS;
		}
		return ERROR;
	}


	/**
	 * Gets the routes list.
	 *
	 * @return the routes list
	 */
	public List<Routes> getRoutesList() {
		return routesList;
	}


	/**
	 * Sets the routes list.
	 *
	 * @param routesList the new routes list
	 */
	public void setRoutesList(List<Routes> routesList) {
		this.routesList = routesList;
	}


}
