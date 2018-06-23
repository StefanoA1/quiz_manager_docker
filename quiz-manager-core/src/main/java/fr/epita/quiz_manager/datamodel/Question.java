package fr.epita.quiz_manager.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.epita.quiz_manager.datamodel.QuestionType;

/**
 * <h3>Description</h3>
 * <p>This Question class is used to model questions, it includes 3 properties, 
 * uses queries predefined in the applicationContext</p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	private Question instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */

@Entity
public class Question {
	/* fields */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String title;
	private QuestionType type;
	
	
	/* accessors */
	/**
	 * @return the question
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the type
	 */
	public QuestionType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(QuestionType type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
