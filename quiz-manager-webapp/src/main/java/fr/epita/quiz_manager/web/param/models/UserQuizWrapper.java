package fr.epita.quiz_manager.web.param.models;

import java.util.List;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Quiz;
import fr.epita.quiz_manager.datamodel.UserQuiz;
/**
 * <h3>Description</h3>
 * <p>This UserQuizWrapper class is used to wrap a questions and answers to use get and post methods,
 * , it includes 3 fields: </p>
 * <p><pre><code>
 * private UserQuiz userquiz;
 * private Quiz quiz;
 * private List &lt MCQChoice &gt instance;
 * </code></pre></p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	private UserQuizWrapper instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
public class UserQuizWrapper {
	
	private UserQuiz userquiz;
	private Quiz quiz;
	private List<MCQChoice> answers;
	/**
	 * @return the userquiz
	 */
	public UserQuiz getUserquiz() {
		return userquiz;
	}
	/**
	 * @param userquiz the userquiz to set
	 */
	public void setUserquiz(UserQuiz userquiz) {
		this.userquiz = userquiz;
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
	
	
}
