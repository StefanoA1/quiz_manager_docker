package fr.epita.quiz_manager.services;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

public class UserQuizOperationsService {
	@Inject
	private UserQuizDAO userquizdao;
	@Inject
	private QuizDAO quizdao;
	@Inject
	private SessionFactory factory;

}
