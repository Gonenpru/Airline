package action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.FlightsDAO;
import db_items.Flights;

public class FlightsAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Flights flights;
	private List<Flights> flightsList;
	private FlightsDAO flightsDao;
	private int id;
	
	public FlightsAction(){
		flightsDao = new FlightsDAO();
	}
	
	public String execute(){
		if (flightsDao.list() != null) {
			this.flightsList = flightsDao.list();
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String add(){
		try{
			Flights flights = getFlights();
			flights.setId(flightsDao.list().get(flightsDao.list().size() - 1).getId() + 1);
			flights.setDelay(new Date());
			flightsDao.add(flights);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return execute();
	}
	
	public String delete(){
		flightsDao.delete(getId());
		return this.execute();
	}
	
	public String list(){
		this.flightsList = flightsDao.list();
		return SUCCESS;
	}

	public Flights getFlights() {
		return flights;
	}

	public void setFlights(Flights flights) {
		this.flights = flights;
	}

	public List<Flights> getFlightsList() {
		return flightsList;
	}

	public void setFlightsList(List<Flights> flightsList) {
		this.flightsList = flightsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
}
