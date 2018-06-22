package fr.epita.quiz_manager.web.services;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;

import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.datamodel.Quiz;
import fr.epita.quiz_manager.services.QuizOperationsService;
import fr.epita.quiz_manager.web.param.models.QuizAndQuestions;

@Path("/quizzes")
public class QuizService {
	@Inject
	private QuizOperationsService quizServices;
	
	@POST
	@Path("/create")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public boolean createQuiz(@WebParam QuizAndQuestions quizAndQuestions) {
		quizServices.createQuiz(quizAndQuestions.getQuiz(), quizAndQuestions.getQuestionsSet());
		return true;
	}
	
	@GET
	@Path("/")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<Quiz> getQuizzes() {
		return quizServices.search(new Quiz());
	}
	
	@GET
	@Path("/except")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<Question> getOtherQuestions(Quiz quiz) {
		return quizServices.searchExcept(quiz);
	}
	
	@POST
	@Path("/delete")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public void deleteQuiz(Quiz quiz) {
		quizServices.deleteQuiz(quiz);
	}
	
	@POST
	@Path("/update")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public void updateQuiz(@WebParam QuizAndQuestions quizAndQuestions) {
		quizServices.updateQuiz(quizAndQuestions.getQuiz(), quizAndQuestions.getQuestionsSet());
	}
}
