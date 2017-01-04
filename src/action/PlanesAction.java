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
	private Long id;
	private PlanesDAO planesDao;

	public PlanesAction() {
		planesDao = new PlanesDAO();
	}
	
	public String execute() {
		this.planesList = planesDao.list();
		return SUCCESS;
	}
	
	public String add() {
		try {
			Planes plane = getPlane();
			planesDao.add(plane);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.planesList = planesDao.list();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
