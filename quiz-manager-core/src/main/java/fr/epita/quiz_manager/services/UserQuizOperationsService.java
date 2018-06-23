package fr.epita.quiz_manager.services;

import java.util.List;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Quiz;
import fr.epita.quiz_manager.datamodel.UserQuiz;

/**
 * <h3>Description</h3>
 * <p>This UserQuizOperationsService class is used to
 * provide
 * services: 
 * create, search
 *  for {@link UserQuiz}
 * object types, it includes 3 fields: </p>
 * <p><pre><code>
 * 	&#64Inject
 * 	private UserQuizDAO instance;
 *
 *	&#64Inject
 *	private SessionFactory instance;
 * </code></pre></p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	&#64Inject
 *	UserQuizOperationsService instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */

public class UserQuizOperationsService {
	@Inject
	private UserQuizDAO userquizdao;
	@Inject
	private SessionFactory factory;
	
	public void createUserQuiz(UserQuiz userquiz, Quiz quiz, List<MCQChoice> answers) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();
		userquizdao.create(userquiz, session);
		userquiz.setQuiz(quiz);
		userquiz.setAnswers(answers);
		transaction.commit();
		session.close();
	}
	
	public List<UserQuiz> search(UserQuiz criteria) {
		// Look for possible quizzes to match criteria
		return userquizdao.search(criteria);
	}

}
