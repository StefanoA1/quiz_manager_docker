package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;

import fr.epita.quiz_manager.datamodel.MCQChoice;

/**
 * reserved for javadoc
 */
public class MCQChoiceDAO extends GenericORMDao<MCQChoice> {

	/*
	 * (non-Javadoc)
	 * @see fr.epita.quiz.services.GenericORMDao#getWhereClauseBuilder(java.lang.Object)
	 */
	@Override
	protected WhereClauseBuilder<MCQChoice> getWhereClauseBuilder(MCQChoice entity) {
		final WhereClauseBuilder<MCQChoice> whereClauseBuilder = new WhereClauseBuilder<>();
		whereClauseBuilder.setParameters(new LinkedHashMap<>());

		// TODO : load from configuration
		final String query = "from MCQChoice";

		whereClauseBuilder.setQueryString(query);
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
