package fr.epita.quiz_manager.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz_manager.datamodel.Question;
import fr.epita.quiz_manager.datamodel.User;

public class UserDAO extends GenericORMDao<User>{

	@Inject
	@Named("userQuery")
	String query;
	
	@Override
	protected WhereClauseBuilder<User> getWhereClauseBuilder(User entity) {
		final WhereClauseBuilder<User> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(query);

		final Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("username", entity.getUsername());
		parameters.put("password", entity.getPassword());
		wcb.setParameters(parameters);
		return wcb;


	}

}
