package fr.epita.quiz_manager.services;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.datamodel.Quiz;

/**
 * <h3>Description</h3>
 * <p>This QuizOperationsService class is used to
 * provide
 * services
 * create, update, search, delete and searchExcept
 *  for {@link Quiz}
 * object types, it includes 3 fields: </p>
 * <p><pre><code>
 * 	&#64Inject
 * 	private QuizDAO instance;
 *
 *	&#64Inject
 *	QuestionOperationsService instance;
 *
 *	&#64Inject
 *	private SessionFactory instance;
 * </code></pre></p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	&#64Inject
 *	QuizOperationsService instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
public class QuizOperationsService {
	@Inject
	private QuizDAO quizdao;
	@Inject
	private SessionFactory factory;
	@Inject
	QuestionOperationsService questionOperationsService;

	public void createQuiz(Quiz quiz) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();
		quizdao.create(quiz, session);
		transaction.commit();
		session.close();
	}

	public void updateQuiz(Quiz quiz) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();

		// update quiz
		quizdao.update(quiz, session);

		transaction.commit();
		session.close();
	}
	
	public List<Quiz> search(Quiz criteria) {
		// Look for possible quizzes to match criteria
		return quizdao.search(criteria);
	}
	
	public List<Question> searchExcept(Quiz criteria) {
		// Look for possible quizzes to match criteria
		Question emptyQuestion = new Question();
		List<Question> allQuestions;
		allQuestions = questionOperationsService.search(emptyQuestion);
		Set<Question> quizQuestions = quizdao.search(criteria).get(0).getQuestionList();
		allQuestions.removeAll(quizQuestions);
		return allQuestions;
	}
	
	public void deleteQuiz(Quiz quiz) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();

		quizdao.delete(quiz, session);
		transaction.commit();
		session.close();
	}

}
