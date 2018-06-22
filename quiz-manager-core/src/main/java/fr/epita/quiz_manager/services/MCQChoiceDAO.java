package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.MCQChoice;

/**
 * reserved for javadoc
 */
public class MCQChoiceDAO extends GenericORMDao<MCQChoice> {

	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
	@Inject
	@Named("mcqChoiceQuery")
	private String query;
	
	@Override
	protected WhereClauseBuilder<MCQChoice> getWhereClauseBuilder(MCQChoice entity) {
		final WhereClauseBuilder<MCQChoice> whereClauseBuilder = new WhereClauseBuilder<>();
		final Map<String,Object> parameters = new LinkedHashMap<>();
		whereClauseBuilder.setQueryString(query);
		whereClauseBuilder.setParameters(parameters);
		parameters.put("id", entity.getId());
		parameters.put("choice", entity.getChoice());
		parameters.put("correct", entity.isCorrect());
		parameters.put("questionId", entity.getQuestion().getId());
		
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
