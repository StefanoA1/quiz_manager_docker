package fr.epita.quiz_manager.web.services;

import javax.inject.Inject;
import javax.ws.rs.Path;

import fr.epita.quiz_manager.services.UserQuizOperationsService;

@Path("/userquizzes")
public class UserQuizService {
	@Inject
	private UserQuizOperationsService userquizServices;

}
