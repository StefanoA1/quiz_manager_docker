
package fr.epita.quiz_manager.services;

import java.util.Map;

/**
 * <h3>Description</h3>
 * <p>This WhereClauseBuilder generic class will provide a
 * bonus
 * ,as it Maps parameters to simplify the queryString generation for each type of class.
 * Used in:
 *  for {@link GenericORMDao}
 * object types, it includes 2 fields: </p>
 * <p><pre><code>
 * 	private Map<String, Object> parameters;
 *
 *	private String queryString;
 * </code></pre></p>
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	&#64Inject
 *	UserOperationsService instance;
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
public class WhereClauseBuilder<T> {

	private Map<String, Object> parameters;
	private String queryString;

	/**
	 * @return the parameters
	 */
	public Map<String, Object> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}

	/**
	 * @param queryString
	 *            the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

}
