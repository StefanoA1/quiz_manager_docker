package fr.epita.quiz_manager.services;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.User;

/**
 * <h3>Description</h3>
 * <p>This UserDAO class is used to manage objects type {@link User} persisted in the database 
 * using queries predefined in the applicationContext</p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *   &#64Inject
 *	private UserDAO instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */

public class UserDAO extends GenericORMDao<User>{

	@Inject
	@Named("userQuery")
	String query;
	
	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
	@Override
	protected WhereClauseBuilder<User> getWhereClauseBuilder(User entity) {
		final WhereClauseBuilder<User> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(query);

		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("username", entity.getUsername());
		parameters.put("password", entity.getPassword());
		parameters.put("name", entity.getName());
		parameters.put("type", entity.getUserType());
		wcb.setParameters(parameters);
		return wcb;


	}

}
