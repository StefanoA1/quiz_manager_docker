package fr.epita.quiz_manager.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.epita.quiz_manager.datamodel.Question;

/**
 * <h3>Description</h3>
 * <p>This MCQChoice class is used to model multiple questions choices, it includes 4 fields 
 * and indicates parameters to be persisted in the DB as the id, for being a PKt</p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	private MCQChoice instance = new MCQChoice();
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */

@Entity
public class MCQChoice {
	/* fields */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String choice;
	// true for correct answer, false otherwise
	private Boolean correct;

	@ManyToOne
	private Question question;

	/**
	 *
	 */
	/* constructor */
	
	public MCQChoice() {

	}
	/* accessors */
	/**
	 * @return the choice
	 */
	public String getChoice() {
		return choice;
	}

	/**
	 * @param choice
	 *            the choice to set
	 */
	public void setChoice(String choice) {
		this.choice = choice;
	}

	/**
	 * @return the valid
	 */
	public Boolean isCorrect() {
		return correct;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setCorrect(Boolean correct) {
		this.correct = correct;
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

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This methods allows to ...
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 *
	 * <pre>
	 * <code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code>
	 * </pre>
	 * </p>
	 *
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 *         ${tags}
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

}
