package fr.epita.quiz_manager.web.param.models;

import java.util.List;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Question;
/**
 * <h3>Description</h3>
 * <p>This MCQQuestion class is used to wrap a questions and answers to use get and post methods,
 * , it includes 2 fields: </p>
 * <p><pre><code>
 * private Question question;
 * private List &lt MCQChoice &gt instance;
 * </code></pre></p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	private MCQQuestion instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
public class MCQQuestion {

	private Question question;
	private List<MCQChoice> answers;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<MCQChoice> getAnswers() {
		return answers;
	}
	public void setAnswers(List<MCQChoice> answers) {
		this.answers = answers;
	}
}
