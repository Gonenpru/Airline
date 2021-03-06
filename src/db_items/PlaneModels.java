/*
 * 
 */
package db_items;
// Generated 04-ene-2017 11:51:08 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * PlaneModels generated by hbm2java.
 */

@Entity
@Table(name="PlaneModels")
public class PlaneModels implements java.io.Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name="id")
	private int id;
	
	/** The manufacturer id. */
	@Column(name="manufacturer_id")
	private int manufacturer_id;
	
	/** The name. */
	@Column(name="name")
	private String name;
	
	/** The max passengers. */
	@Column(name="max_passengers")
	private Integer maxPassengers;
	
	/**
	 * Instantiates a new plane models.
	 */
	public PlaneModels() {
	}

	/**
	 * Instantiates a new plane models.
	 *
	 * @param id the id
	 */
	public PlaneModels(int id) {
		this.id = id;
	}

	/**
	 * Instantiates a new plane models.
	 *
	 * @param id the id
	 * @param manufacturer_id the manufacturer id
	 * @param name the name
	 * @param maxPassengers the max passengers
	 */
	public PlaneModels(int id, int manufacturer_id, String name, Integer maxPassengers) {
		this.id = id;
		this.manufacturer_id = manufacturer_id;
		this.name = name;
		this.maxPassengers = maxPassengers;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the manufacturer id.
	 *
	 * @return the manufacturer id
	 */
	public int getManufacturer_id() {
		return manufacturer_id;
	}

	/**
	 * Sets the manufacturer id.
	 *
	 * @param manufacturer_id the new manufacturer id
	 */
	public void setManufacturer_id(int manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the max passengers.
	 *
	 * @return the max passengers
	 */
	public Integer getMaxPassengers() {
		return this.maxPassengers;
	}

	/**
	 * Sets the max passengers.
	 *
	 * @param maxPassengers the new max passengers
	 */
	public void setMaxPassengers(Integer maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
}
