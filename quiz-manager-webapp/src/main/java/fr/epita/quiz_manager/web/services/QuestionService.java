package fr.epita.quiz_manager.web.services;

import java.util.List;

import javax.jws.WebParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import fr.epita.quiz_manager.datamodel.MCQChoice;
import fr.epita.quiz_manager.datamodel.Question;

@Path("/questions")
public class QuestionService {

	
	
	@POST
	@Path("/create")
	public void create(@WebParam Question q, @WebParam List<MCQChoice> answers) {
		
	}
	
}
