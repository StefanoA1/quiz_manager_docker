package fr.epita.quiz_manager.datamodel;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * <h3>Description</h3>
 * <p>This Quiz class is used to model quizzes, it includes 3 fields: </p>
 * <p><pre><code>
 * Integer id;
 * String name;
 * Set &ltQuestion&gt questionList;
 * </code></pre></p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	private Quiz instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */

@Entity
public class Quiz {
	/* fields */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Question> questionList;
	
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
	 * @return questionsSet
	 */
	public Set<Question> getQuestionList() {
		return questionList;
	}
	/**
	 * @param questionList a set of Questions
	 */
	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}
	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id Integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
