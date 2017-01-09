package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.PlanesDAO;
import db_items.Planes;

public class PlanesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Planes plane;
	private List<Planes> planesList;
	private int id;
	private int totalPlanes;
	private PlanesDAO planesDao;

	public PlanesAction() {
		planesDao = new PlanesDAO();
	}
	
	public String execute() {
		this.planesList = planesDao.list();
		this.totalPlanes = planesList.size();
		return SUCCESS;
	}
	
	public String add() {
		try {
			Planes plane = getPlane();
			plane.setId(planesDao.list().get(planesDao.list().size() - 1).getId() + 1);
			planesDao.add(plane);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.planesList = planesDao.list();
		this.totalPlanes = planesList.size();
		return SUCCESS;
	}
	
	public String list(){
		this.planesList = planesDao.list();
		return SUCCESS;
	}
	
	public String delete(){
		planesDao.delete(getId());
		return SUCCESS;
	}

	public Planes getPlane() {
		return plane;
	}

	public void setPlane(Planes plane) {
		this.plane = plane;
	}
	
	public List<Planes> getPlanesList() {
		return planesList;
	}

	public void setPlanesList(List<Planes> planesList) {
		this.planesList = planesList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalPlanes() {
		return totalPlanes;
	}

	public void setTotalPlanes(int totalPlanes) {
		this.totalPlanes = totalPlanes;
	}
}
