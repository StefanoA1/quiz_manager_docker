package fr.epita.quiz_manager.datamodel;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserQuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private User user;
	
	private ArrayList<MCQChoice> answers;
	@ManyToOne
	private Quiz quiz;
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
	public ArrayList<MCQChoice> getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(ArrayList<MCQChoice> answers) {
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
	
	
}
