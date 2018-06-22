package fr.epita.quiz_manager.web.services;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.services.QuestionOperationsService;
import fr.epita.quiz_manager.web.param.models.MCQQuestion;

@Path("/questions")
public class QuestionService {

	@Inject
	QuestionOperationsService questionOperationsService;
	
	@GET
	@Path("/")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<Question> getUsers() {
		return questionOperationsService.search(new Question());
	}
	
	@POST
	@Path("/createMCQQuestion")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public void create(@WebParam MCQQuestion question) {
		questionOperationsService.createMCQQuestion(question.getQuestion(), question.getAnswers());
	}
	
}
