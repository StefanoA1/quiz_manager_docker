package fr.epita.quiz_manager.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.quiz_manager.datamodel.Quiz;
import fr.epita.quiz_manager.datamodel.User;

/**
 * <h3>Description</h3>
 * <p>This UserOperationsService class is used to
 * provide
 * services: 
 * create, update, authenticate, delete, search
 *  for {@link User}
 * object types, it includes 3 fields: </p>
 * <p><pre><code>
 * 	&#64Inject
 * 	private UserDAO instance;
 *
 *	&#64Inject
 *	private SessionFactory instance;
 * </code></pre></p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	&#64Inject
 *	UserOperationsService instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
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
	
	public void deleteUser(User user) {
		final Session session = factory.openSession();
		final Transaction transaction = session.beginTransaction();
		userDAO.delete(user, session);
		transaction.commit();
		session.close();
	}
}
