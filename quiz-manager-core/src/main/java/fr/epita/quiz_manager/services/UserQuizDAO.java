package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.UserQuiz;

/**
 * <h3>Description</h3>
 * <p>This UserDAO class is used to manage objects type {@link UserQuiz} persisted in the database 
 * using queries predefined in the applicationContext</p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *   &#64Inject
 *	private UserQuizDAO instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
public class UserQuizDAO extends GenericORMDao<UserQuiz> {
	@Inject
	@Named("userquizQuery")
	String query;
	
	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
	@Override
	protected WhereClauseBuilder<UserQuiz> getWhereClauseBuilder(UserQuiz entity) {
		final WhereClauseBuilder<UserQuiz> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(query);

		final Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("id", entity.getId());
		parameters.put("user", entity.getUser());
		parameters.put("quiz", entity.getQuiz());
		parameters.put("score", entity.getScore());
		wcb.setParameters(parameters);
		return wcb;
	}

	
}
