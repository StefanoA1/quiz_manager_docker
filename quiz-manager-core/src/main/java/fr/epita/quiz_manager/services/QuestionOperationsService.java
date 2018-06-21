package fr.epita.quiz_manager.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Question;

/**
 * reserved for javadoc
 */
public class QuestionOperationsService {

	@Inject
	private MCQChoiceDAO mcqChoicedao;

	@Inject
	private QuestionDAO questiondao;

	@Inject
	private SessionFactory factory;

	// @Transactional
	// TODO check that in a further lecture
	public void deleteQuestion(Question question) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();
		final MCQChoice criteria = new MCQChoice();
		criteria.setQuestion(question);
		final List<MCQChoice> choicesList = mcqChoicedao.search(criteria);
		for (final MCQChoice choice : choicesList) {
			mcqChoicedao.delete(choice, session);
		}
		questiondao.delete(question, session);
		transaction.commit();
		session.close();
	}
	
	public void createQuestion(Question question, List<MCQChoice> answers) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();
		questiondao.create(question, session);
		for(MCQChoice choice : answers) {
			choice.setQuestion(question);
			mcqChoicedao.create(choice, session);
		}
		transaction.commit();
		session.close();
	}

}
