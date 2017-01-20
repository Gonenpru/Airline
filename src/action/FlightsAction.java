/*
 * 
 */
package action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.FlightDao;
import db_items.Flights;

// TODO: Auto-generated Javadoc
/**
 * The Class FlightsAction.
 */
public class FlightsAction extends ActionSupport {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The flights. */
	private Flights flights;
	
	/** The flights list. */
	private List<Flights> flightsList;
	
	/** The flights dao. */
	private FlightDao flightsDao;
	
	/** The id. */
	private int id;
	
	/**
	 * Instantiates a new flights action.
	 */
	public FlightsAction(){
		flightsDao = new FlightDao();
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		if (flightsDao.list() != null) {
			this.flightsList = flightsDao.list();
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * Adds the.
	 *
	 * @return the string
	 */
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
	
	/**
	 * Updator.
	 *
	 * @return the string
	 */
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
	
	/**
	 * Update.
	 *
	 * @return the string
	 */
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

	
	/**
	 * Delete.
	 *
	 * @return the string
	 */
	public String delete(){
		flightsDao.delete(getId());
		return this.execute();
	}
	
	/**
	 * List.
	 *
	 * @return the string
	 */
	public String list(){
		this.flightsList = flightsDao.list();
		return SUCCESS;
	}

	/**
	 * Gets the flights.
	 *
	 * @return the flights
	 */
	public Flights getFlights() {
		return flights;
	}

	/**
	 * Sets the flights.
	 *
	 * @param flights the new flights
	 */
	public void setFlights(Flights flights) {
		this.flights = flights;
	}

	/**
	 * Gets the flights list.
	 *
	 * @return the flights list
	 */
	public List<Flights> getFlightsList() {
		return flightsList;
	}

	/**
	 * Sets the flights list.
	 *
	 * @param flightsList the new flights list
	 */
	public void setFlightsList(List<Flights> flightsList) {
		this.flightsList = flightsList;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
