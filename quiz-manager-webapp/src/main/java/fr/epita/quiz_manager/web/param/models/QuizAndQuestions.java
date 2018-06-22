package fr.epita.quiz_manager.web.param.models;

import java.util.Set;

import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.datamodel.Quiz;

public class QuizAndQuestions {
	private Quiz quiz;
	private Set<Question> questionsSet;
	/**
	 * @return the quiz
	 */
	public Quiz getQuiz() {
		return quiz;
	}
	/**
	 * @param quiz the quiz to set
	 */
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	/**
	 * @return the questionsSet
	 */
	public Set<Question> getQuestionsSet() {
		return questionsSet;
	}
	/**
	 * @param questionsSet the questionsSet to set
	 */
	public void setQuestionsSet(Set<Question> questionsSet) {
		this.questionsSet = questionsSet;
	}
	
}
