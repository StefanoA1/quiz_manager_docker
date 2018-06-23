package fr.epita.quiz_manager.datamodel;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * <h3>Description</h3>
 * <p>This UserQuiz class is used to model a special kind of quizzes, which are quizzes taken by a User
 * , it includes 5 fields: </p>
 * <p><pre><code>
 * Integer id;
 * User user;
 * List&ltMCQChoice&gt answers;
 * Quiz quiz;
 * Double score;
 * </code></pre></p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	private UserQuiz instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
@Entity
public class UserQuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private User user;
	@Transient
	private List<MCQChoice> answers;
	@ManyToOne
	private Quiz quiz;
	
	private Double score;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the answers
	 */
	public List<MCQChoice> getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<MCQChoice> answers) {
		this.answers = answers;
	}
	/**
	 * @return the quiz
	 */
	public Quiz getQuiz() {
		return quiz;
	}
	/**
	 * @param quiz the quiz to set
	 */
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	/**
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}
	
	
}
