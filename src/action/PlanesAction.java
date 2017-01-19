/*
 * 
 */
package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.PlaneDao;
import db_items.Planes;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanesAction.
 */
public class PlanesAction extends ActionSupport {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The planes. */
	private Planes planes;
	
	/** The planes list. */
	private List<Planes> planesList;
	
	/** The plane dao. */
	private PlaneDao planeDao;
	
	/**
	 * Instantiates a new planes action.
	 */
	public PlanesAction(){
		planeDao = new PlaneDao();
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		System.out.println("Execute Flight");
		if (planeDao.list() != null) {
			this.planesList = planeDao.list();
			for (int i = 0; i < planesList.size(); i++){
				this.planesList.get(i).setPlane_name(planeDao.getPlaneName(planesList.get(i).getId()));
				this.planesList.get(i).setNumberHours(planeDao.getPlaneHours(planesList.get(i).getId()));
				this.planesList.get(i).setNumberFlights(planeDao.getPlaneFlights(planesList.get(i).getId()));
			}
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * Gets the planes.
	 *
	 * @return the planes
	 */
	public Planes getPlanes() {
		return planes;
	}

	/**
	 * Sets the planes.
	 *
	 * @param planes the new planes
	 */
	public void setPlanes(Planes planes) {
		this.planes = planes;
	}

	/**
	 * Gets the planes list.
	 *
	 * @return the planes list
	 */
	public List<Planes> getPlanesList() {
		return planesList;
	}

	/**
	 * Sets the planes list.
	 *
	 * @param planesList the new planes list
	 */
	public void setPlanesList(List<Planes> planesList) {
		this.planesList = planesList;
	}
}
