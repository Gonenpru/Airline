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
 * Airlines generated by hbm2java.
 */

@Entity
@Table(name="Airlines")
public class Airlines implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name="id")
	private int id;
	
	/** The name. */
	@Column(name="name")
	private String name;
	
	/** The email. */
	@Column(name="email")
	private String email;
	
	/** The password. */
	@Column(name="password")
	private String password;


	/**
	 * Instantiates a new airlines.
	 */
	public Airlines() {
	}

	/**
	 * Instantiates a new airlines.
	 *
	 * @param id the id
	 */
	public Airlines(int id) {
		this.id = id;
	}

	/**
	 * Instantiates a new airlines.
	 *
	 * @param id the id
	 * @param name the name
	 * @param email the email
	 * @param password the password
	 */
	public Airlines(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
