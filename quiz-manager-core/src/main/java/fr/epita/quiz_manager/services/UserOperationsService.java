package fr.epita.quiz_manager.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.quiz_manager.datamodel.User;

public class UserOperationsService {

	@Inject
	private UserDAO userDAO;
	@Inject
	private SessionFactory factory;

	
	public boolean authenticate(String username, String password) {
		User criteria = new User();
		boolean authenticated = false;
		criteria.setPassword(password);
		criteria.setUsername(username);
		final List<User> results = userDAO.search(criteria);
		if(results.size() == 1) {
			authenticated = true;
		}
		
		return authenticated;
	}
	
	public void createUser(User user) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();
		userDAO.create(user, session);
		transaction.commit();
		session.close();
	}
	
	public List<User> search(User criteria) {
		return userDAO.search(criteria);
	}
	
}
