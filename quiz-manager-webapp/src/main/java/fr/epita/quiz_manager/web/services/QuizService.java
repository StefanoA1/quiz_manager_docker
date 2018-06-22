package fr.epita.quiz_manager.web.services;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.jws.WebParam;
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
	public boolean createQuiz(@WebParam Quiz criteria, @WebParam ArrayList<Question> questionsList) {
		quizServices.createQuiz(criteria, questionsList);
		return true;
	}
	
	
}
