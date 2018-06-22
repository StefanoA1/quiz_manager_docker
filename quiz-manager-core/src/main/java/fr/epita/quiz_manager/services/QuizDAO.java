package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.Quiz;

public class QuizDAO extends GenericORMDao<Quiz> {
	
	@Inject
	@Named("quizQuery")
	String query;

	@Override
	protected WhereClauseBuilder<Quiz> getWhereClauseBuilder(Quiz entity) {
		final WhereClauseBuilder<Quiz> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(query);

		// TODO as bonus : let the whereclausebuilder generate this map thanks to introspection
		final Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("id", entity.getId());
		parameters.put("name", entity.getName());
		parameters.put("questionList", entity.getQuestionList());
		wcb.setParameters(parameters);
		return wcb;
	}
	

}
