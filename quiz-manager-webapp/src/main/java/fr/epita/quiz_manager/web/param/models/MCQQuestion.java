package fr.epita.quiz_manager.web.param.models;

import java.util.List;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Question;

public class MCQQuestion {

	private Question question;
	private List<MCQChoice> answers;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<MCQChoice> getAnswers() {
		return answers;
	}
	public void setAnswers(List<MCQChoice> answers) {
		this.answers = answers;
	}
}
