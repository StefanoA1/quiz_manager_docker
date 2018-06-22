package fr.epita.quizManager.test;

import java.util.ArrayList;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	SessionFactory factory;

	@Test
	public void testSave() {
		final Session session = factory.openSession();
		final Transaction tx = session.beginTransaction();
		final Quiz quiz = new Quiz();
		quiz.setName("Maven Test");
		
		quizDAO.create(quiz, session);
		
		final ArrayList<Question> questions = new ArrayList<Question>();		
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
		tx.commit();

	}

}
