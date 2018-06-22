package fr.epita.quiz_manager.web.services;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;

import fr.epita.quiz_manager.datamodel.UserQuiz;
import fr.epita.quiz_manager.services.UserQuizOperationsService;
import fr.epita.quiz_manager.web.param.models.UserQuizWrapper;

@Path("/userquizzes")
public class UserQuizService {
	
	@Inject
	private UserQuizOperationsService userquizServices;
	
	@POST
	@Path("/create")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public boolean createUserQuiz(@WebParam UserQuizWrapper userquizWrapper) {
		userquizServices.createUserQuiz(userquizWrapper.getUserquiz(), userquizWrapper.getQuiz(), userquizWrapper.getAnswers());
		return true;
	}
	
	@GET
	@Path("/userquizzes")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<UserQuiz> getUserQuizzes() {
		return userquizServices.search(new UserQuiz());
	}

}
