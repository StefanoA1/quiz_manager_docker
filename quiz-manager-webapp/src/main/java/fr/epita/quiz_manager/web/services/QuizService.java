package fr.epita.quiz_manager.web.services;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	public boolean createQuiz(@WebParam Quiz quiz) {
		quizServices.createQuiz(quiz);
		return true;
	}
	
	@GET
	@Path("/")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<Quiz> getQuizzes() {
		return quizServices.search(new Quiz());
	}
	
	@POST
	@Path("/byid")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public Quiz getQuizById(@WebParam Quiz quiz) {
		List<Quiz> tempList = quizServices.search(quiz);
		return tempList.get(0);
	}
	
	@GET
	@Path("/except/{id}")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<Question> getOtherQuestions(@PathParam("id") Integer id) {
		Quiz quiz = new Quiz();
		quiz.setId(id);
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
	public void updateQuiz(@WebParam Quiz quiz) {
		quizServices.updateQuiz(quiz);
	}
}
