package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ManufacturerDAO;
import db_items.Manufacturers;

public class ManufacturersAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Manufacturers manufacturers;
	private List<Manufacturers> manufacturersList;
	private int id;
	private int totalManufacturers;
	private ManufacturerDAO manufacturerDao;
	
	public  ManufacturersAction() {
		manufacturerDao = new ManufacturerDAO();
	}
	
	public String execute(){
		if (manufacturerDao.list() != null) {
			
			this.manufacturersList = manufacturerDao.list();
			this.totalManufacturers = manufacturersList.size();
			System.out.println("In");
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String add(){
		try {
			Manufacturers manufacturer = getManufacturers();
			manufacturer.setId(manufacturerDao.list().get(manufacturerDao.list().size() - 1).getId() + 1);
			manufacturerDao.add(manufacturer);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return execute();
	}
	
	public String delete() {
		manufacturerDao.delete(getId());
		return SUCCESS;
	}
	
	public String list() {
		this.manufacturersList = manufacturerDao.list();
		return SUCCESS;
	}

	public Manufacturers getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(Manufacturers manufacturers) {
		this.manufacturers = manufacturers;
	}

	public List<Manufacturers> getManufacturersList() {
		return manufacturersList;
	}

	public void setManufacturersList(List<Manufacturers> manufacturersList) {
		this.manufacturersList = manufacturersList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalManufacturers() {
		return totalManufacturers;
	}

	public void setTotalManufacturers(int totalManufacturers) {
		this.totalManufacturers = totalManufacturers;
	}
}
