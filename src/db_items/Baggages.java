package db_items;
// Generated 04-ene-2017 11:51:08 by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Baggages generated by hbm2java
 */

@Entity
@Table(name="Baggages")
public class Baggages implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="terminals")
	private Terminals terminals;
	
	@Column(name="name")
	private String name;
	
	private Set flightses = new HashSet(0);

	public Baggages() {
	}

	public Baggages(int id, Terminals terminals) {
		this.id = id;
		this.terminals = terminals;
	}

	public Baggages(int id, Terminals terminals, String name, Set flightses) {
		this.id = id;
		this.terminals = terminals;
		this.name = name;
		this.flightses = flightses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Terminals getTerminals() {
		return this.terminals;
	}

	public void setTerminals(Terminals terminals) {
		this.terminals = terminals;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getFlightses() {
		return this.flightses;
	}

	public void setFlightses(Set flightses) {
		this.flightses = flightses;
	}

}
