package fr.epita.quiz_manager.datamodel;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h3>Description</h3>
 * <p>This User class is used to model possible users for the system, it includes 5 fields 
 * and indicates parameters to be persisted in the DB</p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	private User instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
@Entity(name = "UserData")
@Table(name = "UserData")
public class User {
	/* fields */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String username;
	private String password;
	@Enumerated(EnumType.ORDINAL)
	private UserType userType;
	
	/* accessors */
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public UserType getUserType() {
		return userType;
	}
	/**
	 * @param type the type to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
	
}
