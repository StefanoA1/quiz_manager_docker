package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.Question;

/**
 * <h3>Description</h3>
 * <p>This QuestionDAO class is used to manage questions type {@link Question} persisted in the database 
 * using queries predefined in the applicationContext</p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *   &#64Inject
 *	private QuestionDAO instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */

public class QuestionDAO extends GenericORMDao<Question> {
	/* fields */
	@Inject
	@Named("questionQuery")
	String query;
	
	/* methods */
	
	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
	@Override
	protected WhereClauseBuilder<Question> getWhereClauseBuilder(Question entity) {
		final WhereClauseBuilder<Question> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(query);

		final Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("type", entity.getType());
		parameters.put("title", entity.getTitle());
		parameters.put("id", entity.getId());
		wcb.setParameters(parameters);
		return wcb;

	}

}
