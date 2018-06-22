package fr.epita.quiz_manager.services;

import java.util.ArrayList;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.datamodel.Quiz;

public class QuizOperationsService {
	@Inject
	private QuizDAO quizDAO;
	@Inject
	private QuestionDAO questiondao;
	@Inject
	private SessionFactory factory;
	
	public void createQuiz(Quiz quiz, ArrayList<Question> questions) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();
		quizDAO.create(quiz, session);
		quiz.setQuestionList(questions);
		for(Question question : questions) {
			questiondao.create(question, session);
		}
		transaction.commit();
		session.close();
	}

}
