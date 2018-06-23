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
	public List<Question> getQuestions() {
		return questionOperationsService.search(new Question());
	}
	
	@POST
	@Path("/createMCQQuestion")
	public void create(@WebParam MCQQuestion question) {
		questionOperationsService.createMCQQuestion(question.getQuestion(), question.getAnswers());
	}
	@GET
	@Path("/{id}")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<MCQChoice> getMCQChoices(@PathParam("id") Integer id) {
		Question question = new Question();
		question.setId(id);
		
		return questionOperationsService.searchMCQChoices(question);
	}
	@POST
	@Path("/updateMCQQuestion")
	public void update(@WebParam MCQQuestion question) {
		questionOperationsService.updateMCQQuestion(question.getQuestion(), question.getAnswers());
	}
	
	@POST
	@Path("/deleteMCQQuestion")
	public void delete(@WebParam Question question) {
		questionOperationsService.deleteMCQQuestion(question);
	}
	
}
