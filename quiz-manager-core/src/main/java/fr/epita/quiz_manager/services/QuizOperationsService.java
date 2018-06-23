package fr.epita.quiz_manager.services;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.datamodel.Quiz;

public class QuizOperationsService {
	@Inject
	private QuizDAO quizdao;
	@Inject
	private SessionFactory factory;
	@Inject
	QuestionOperationsService questionOperationsService;

	public void createQuiz(Quiz quiz, Set<Question> questions) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();
		quizdao.create(quiz, session);
		quiz.setQuestionList(questions);
		/*for (Question question : questions) {
			questiondao.create(question, session);
		}*/
		transaction.commit();
		session.close();
	}

	public void updateQuiz(Quiz quiz, Set<Question> questionList) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();

		quiz.setQuestionList(questionList);
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
		allQuestions.removeAll(quizdao.search(criteria).get(0).getQuestionList());
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
