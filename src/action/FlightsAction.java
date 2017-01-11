package action;

import java.text.SimpleDateFormat;
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
	private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
	private String d_Time;
	private String d_Duration;
	
	public FlightsAction(){
		flightsDao = new FlightsDAO();
	}
	
	public String execute(){
		System.out.println("Execute Flight");
		if (flightsDao.list() != null) {
			this.flightsList = flightsDao.list();
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String add(){
		System.out.println("Add Flight");
		try{
			Flights flights = getFlights();
			flights.setId(flightsDao.list().get(flightsDao.list().size() - 1).getId() + 1);
			flights.setDelay(new Date());
			
			// DEPARTURE DATE
		
			d_Time = flights.getD_Time();
			System.out.println(d_Time);
			Date time = formatter.parse(d_Time);
			System.out.println(time.getHours());
			long sum = flights.getD_Departure().getTime() + time.getTime();
			flights.setDateDeparture(new Date(sum));
			
			// DURATION DATE
			d_Duration = flights.getD_Duration();
			System.out.println(d_Duration);
			Date duration = formatter.parse(d_Duration);
			flights.setDuration(duration);

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
