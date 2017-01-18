package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.PlaneDao;
import db_items.Planes;

public class PlanesAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Planes planes;
	private List<Planes> planesList;
	private PlaneDao planeDao;
	
	public PlanesAction(){
		planeDao = new PlaneDao();
	}
	
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

	public Planes getPlanes() {
		return planes;
	}

	public void setPlanes(Planes planes) {
		this.planes = planes;
	}

	public List<Planes> getPlanesList() {
		return planesList;
	}

	public void setPlanesList(List<Planes> planesList) {
		this.planesList = planesList;
	}
}
