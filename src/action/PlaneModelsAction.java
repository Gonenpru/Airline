package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.PlaneModelsDAO;
import db_items.Manufacturers;
import db_items.PlaneModels;

public class PlaneModelsAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PlaneModels planeModels;
	private List<PlaneModels> planeModelsList;
	private int id;
	private int totalPlaneModels;
	private PlaneModelsDAO planeModelsDao;
	private List<Manufacturers> manufacturersList_model;
	private ManufacturersAction m;
	
	public PlaneModelsAction(){
		planeModelsDao = new PlaneModelsDAO();
		m = new ManufacturersAction();
	}
	
	public String execute(){
		if (planeModelsDao.list() != null) {
			this.planeModelsList = planeModelsDao.list();
			this.totalPlaneModels = planeModelsList.size();
			m.execute();
			this.manufacturersList_model = m.getManufacturersList();
		}
		return SUCCESS;
	}
	
	public String add(){
		try{
			PlaneModels planeModels = getPlaneModels();
			planeModels.setId(planeModelsDao.list().get(planeModelsDao.list().size() - 1).getId() + 1);
			planeModelsDao.add(planeModels);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.planeModelsList = planeModelsDao.list();
		m.execute();
		this.manufacturersList_model = m.getManufacturersList();
		return SUCCESS;
	}
	
	public String delete(){
		planeModelsDao.delete(getId());
		return this.execute();
	}
	
	public String list(){
		this.planeModelsList = planeModelsDao.list();
		return SUCCESS;
	} 

	public PlaneModels getPlaneModels() {
		return planeModels;
	}

	public void setPlaneModels(PlaneModels planeModels) {
		this.planeModels = planeModels;
	}

	public List<PlaneModels> getPlaneModelsList() {
		return planeModelsList;
	}

	public void setPlaneModelsList(List<PlaneModels> planeModelsList) {
		this.planeModelsList = planeModelsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalPlaneModels() {
		return totalPlaneModels;
	}

	public void setTotalPlaneModels(int totalPlaneModels) {
		this.totalPlaneModels = totalPlaneModels;
	}

	public List<Manufacturers> getManufacturersList_model() {
		return manufacturersList_model;
	}

	public void setManufacturersList_model(List<Manufacturers> manufacturersList_model) {
		this.manufacturersList_model = manufacturersList_model;
	}	
}
