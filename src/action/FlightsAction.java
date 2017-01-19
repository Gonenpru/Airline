package action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.FlightDao;
import db_items.Flights;

public class FlightsAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Flights flights;
	private List<Flights> flightsList;
	private FlightDao flightsDao;
	private int id;
	
	public FlightsAction(){
		flightsDao = new FlightDao();
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
			flights.setDelay("00:00");
			System.out.println(flightsDao.list().size());
			
			// DEPARTURE DATE
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String reportDate = df.format(flights.getD_Departure());
			reportDate = reportDate.concat(" "+flights.getD_Time()+":00");
			Timestamp ts = Timestamp.valueOf(reportDate);
			flights.setDateDeparture(ts);
				
			flightsDao.add(flights);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return execute();
	}
	
	public String updator(){
		System.out.println("UPDATOR " + getId());
		Flights f = null;
		execute();
		for (int i = 0; i < flightsList.size(); i++){
			int id = flightsList.get(i).getId();
			if (id == getId()){
				f = flightsList.get(i);
				this.flights = f;
			}
		}
		
		if (f != null)
			return SUCCESS;
		return ERROR;

	}
	
	public String update(){
		Flights flights = getFlights();
		flights.setDelay("00:00");
		
		// DEPARTURE DATE
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String reportDate = df.format(flights.getD_Departure());
		reportDate = reportDate.concat(" "+flights.getD_Time()+":00");
		Timestamp ts = Timestamp.valueOf(reportDate);
		flights.setDateDeparture(ts);

		flightsDao.update(getFlights());
		return this.execute();
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
