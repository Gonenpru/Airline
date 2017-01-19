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
 * Controllers generated by hbm2java.
 */

@Entity
@Table(name="Controllers")
public class Controllers implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@Id
	@Column(name="id")
	private int id;
	
	/** The name. */
	@Column(name="name")
	private String name;
	
	/** The surname. */
	@Column(name="surname")
	private String surname;
	
	/** The email. */
	@Column(name="email")
	private String email;
	
	/** The password. */
	@Column(name="password")
	private String password;

	/**
	 * Instantiates a new controllers.
	 */
	public Controllers() {
	}

	/**
	 * Instantiates a new controllers.
	 *
	 * @param id the id
	 */
	public Controllers(int id) {
		this.id = id;
	}

	/**
	 * Instantiates a new controllers.
	 *
	 * @param id the id
	 * @param name the name
	 * @param surname the surname
	 * @param email the email
	 * @param password the password
	 */
	public Controllers(int id, String name, String surname, String email, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
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
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
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
