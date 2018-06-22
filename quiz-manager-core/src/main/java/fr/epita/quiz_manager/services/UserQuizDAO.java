package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.Quiz;
import fr.epita.quiz_manager.datamodel.UserQuiz;

public class UserQuizDAO extends GenericORMDao<UserQuiz> {
	@Inject
	@Named("userquizQuery")
	String query;

	@Override
	protected WhereClauseBuilder<UserQuiz> getWhereClauseBuilder(UserQuiz entity) {
		final WhereClauseBuilder<UserQuiz> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(query);

		// TODO as bonus : let the whereclausebuilder generate this map thanks to introspection
		final Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("id", entity.getId());
		parameters.put("user", entity.getUser());
		parameters.put("quiz", entity.getQuiz());
		parameters.put("score", entity.getScore());
		wcb.setParameters(parameters);
		return wcb;
	}

	
}
