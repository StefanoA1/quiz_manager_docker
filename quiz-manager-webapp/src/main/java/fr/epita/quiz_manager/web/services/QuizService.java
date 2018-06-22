package fr.epita.quiz_manager.web.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

@Path("/quizzes")
public class QuizService {
	@Inject
	private QuizOperationsService quizServices;
	
	@POST
	@Path("/create")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public boolean createQuiz(@WebParam Quiz criteria, @WebParam Set<Question> questionsList) {
		quizServices.createQuiz(criteria, questionsList);
		return true;
	}
	
	@GET
	@Path("/quizzes")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<Quiz> getQuizzes() {
		return quizServices.search(new Quiz());
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
	public void updateQuiz(@WebParam Quiz quiz, @WebParam Set<Question> questionsList) {
		quizServices.updateQuiz(quiz, questionsList);
	}
}
