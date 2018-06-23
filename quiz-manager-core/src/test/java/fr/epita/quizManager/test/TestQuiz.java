package fr.epita.quizManager.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.datamodel.QuestionType;
import fr.epita.quiz_manager.datamodel.Quiz;
import fr.epita.quiz_manager.services.MCQChoiceDAO;
import fr.epita.quiz_manager.services.QuestionDAO;
import fr.epita.quiz_manager.services.QuizDAO;
import fr.epita.quiz_manager.services.QuizOperationsService;

/**
 * <h3>Description</h3>
 * <p>This TestQuiz class is used to
 * test
 * operations
 *  for {@link QuizOperationsService}
 * object types.</p>
 * 
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	See JUnit4
 *	for more information
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestQuiz {
	@Inject
	QuizDAO quizDAO;
	
	@Inject
	QuestionDAO questDAO;
	
	@Inject
	MCQChoiceDAO mcqDAO;
	
	@Inject
	QuizOperationsService quizService;

	@Inject
	SessionFactory factory;

	/**
	 * <h3>Description</h3>
	 * <p>test save operations of Quiz.
	 * </p>
	 */
	@Test
	public void testSave() {
		final Session session = factory.openSession();
		final Transaction tx = session.beginTransaction();
		final Quiz quiz = new Quiz();
		quiz.setName("Maven Test");
		
		
		
		final Set<Question> questions = new HashSet<Question>();		
		final Question question = new Question();
		question.setTitle("How to configure Hibernate?");
		question.setType(QuestionType.MCQ);

		questDAO.create(question, session);

		final MCQChoice choice = new MCQChoice();
		choice.setCorrect(true);
		choice.setChoice("thanks to a LocalSessionFactoryBean instance");
		choice.setQuestion(question);
	
		mcqDAO.create(choice, session);
		questions.add(question);
		quiz.setQuestionList(questions);
		
		quizDAO.create(quiz, session);
		
		List<Quiz> results = quizService.search(quiz);
		tx.commit();
		
		Assert.assertTrue(results.size() > 0);
	}

}
