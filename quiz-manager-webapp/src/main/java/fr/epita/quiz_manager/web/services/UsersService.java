package fr.epita.quiz_manager.web.services;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;

import fr.epita.quiz_manager.datamodel.User;
import fr.epita.quiz_manager.datamodel.UserType;
import fr.epita.quiz_manager.services.UserOperationsService;

@Path("/")
public class UsersService {

	@Inject
	private UserOperationsService userServices;
	
	@POST
	@Path("/auth")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public User authenticate(@WebParam User user) {
		boolean isAuthenticated = userServices.authenticate(user.getUsername(), user.getPassword());
		User selectedUser = null;
		if(isAuthenticated) {
			List<User> users = userServices.search(user);
			selectedUser = users.get(0);
		}
		return selectedUser;
		
	}
	
	@POST
	@Path("/create")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public boolean createUser(@WebParam User criteria) {
		userServices.createUser(criteria);
		return true;
	}
	
	@GET
	@Path("/users")
	@Produces(value = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getUsers() {
		return userServices.search(new User());
	}
}
