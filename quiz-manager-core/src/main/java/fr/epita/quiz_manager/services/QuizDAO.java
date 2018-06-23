package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.Quiz;

/**
 * <h3>Description</h3>
 * <p>This QuizDAO class is used to manage objects type {@link Quiz} persisted in the database 
 * using queries predefined in the applicationContext</p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *   &#64Inject
 *	private QuizDAO instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
public class QuizDAO extends GenericORMDao<Quiz> {
	
	@Inject
	@Named("quizQuery")
	String query;
	
	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
	@Override
	protected WhereClauseBuilder<Quiz> getWhereClauseBuilder(Quiz entity) {
		final WhereClauseBuilder<Quiz> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(query);

		final Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("id", entity.getId());
		parameters.put("name", entity.getName());
		wcb.setParameters(parameters);
		return wcb;
	}
	

}
