package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.MCQChoice;

/**
 * <h3>Description</h3>
 * <p>This MCQChoiceDAO class is used to manage answers type {@link MCQChoice} persisted in the database 
 * using queries predefined in the applicationContext</p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *   &#64Inject
 *	private MCQChoiceDAO instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */

public class MCQChoiceDAO extends GenericORMDao<MCQChoice> {

	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
	@Inject
	@Named("mcqChoiceQuery")
	private String query;
	
	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
	@Override
	protected WhereClauseBuilder<MCQChoice> getWhereClauseBuilder(MCQChoice entity) {
		final WhereClauseBuilder<MCQChoice> whereClauseBuilder = new WhereClauseBuilder<>();
		final Map<String,Object> parameters = new LinkedHashMap<>();
		whereClauseBuilder.setQueryString(query);
		whereClauseBuilder.setParameters(parameters);
		parameters.put("id", entity.getId());
		parameters.put("choice", entity.getChoice());
		parameters.put("correct", entity.isCorrect());
		parameters.put("question", entity.getQuestion());
		
		return whereClauseBuilder;

	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#beforeCreate(java.lang.Object)
	 */
	@Override
	public boolean beforeCreate(MCQChoice entity) {
		return entity.getChoice() != null && entity.getQuestion() != null;

	}

}
