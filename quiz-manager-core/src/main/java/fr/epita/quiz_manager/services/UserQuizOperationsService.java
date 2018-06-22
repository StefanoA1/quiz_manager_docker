package fr.epita.quiz_manager.services;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Quiz;
import fr.epita.quiz_manager.datamodel.UserQuiz;

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

}
