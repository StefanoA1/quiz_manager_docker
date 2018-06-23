package fr.epita.quiz_manager.services;

import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


/**
 * <h3>Description</h3>
 * <p>This GenericORMDao&ltT&gt abstract class is used to be derived being a generic
 * DAO class to interact with the ORM. 
 * using queries predefined in the applicationContext</p>
 * <h3>Usage</h3>
 * <p>This class should be used to extend other classes as follows:<pre><code>
 * public class classTypeDAO extends GenericORMDao&ltclassType&gt
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */
public abstract class GenericORMDao<T> {

	@Inject
	SessionFactory sf;
	
	private static final Logger LOGGER = LogManager.getLogger(GenericORMDao.class);

	public final void create(T entity, Session session) {
		if (!beforeCreate(entity)) {
			return;
		}

		session.saveOrUpdate(entity);
		

	}

	protected boolean beforeCreate(T entity) {
		return entity != null;
	}

	public final void update(T entity, Session session) {
		session.saveOrUpdate(entity);
	}

	public final void delete(T entity, Session session) {
		session.delete(entity);
	}

	public final List<T> search(T entity) {
		Query searchQuery = null;
		Session session = null;
		List<T> results = null;
		try {
			session = sf.openSession();
			final WhereClauseBuilder<T> wcb = getWhereClauseBuilder(entity);
			searchQuery = session.createQuery(wcb.getQueryString());
			for (final Entry<String, Object> parameterEntry : wcb.getParameters().entrySet()) {
				searchQuery.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
			}
			results = searchQuery.list();

			
		} catch (Exception e) {
			LOGGER.error("Error while searching " + entity.getClass().getName(), e);
		} finally {
			if(session != null) {
				session.close();
			}
			
		}
		
		return results;
		
	}
	/**
	 * <h3>Description</h3>
	 * <p>Given a Type and a query, returns a QueryString
	 *  for using the ORM Hibernate Framework.
	 * </p>
	 * @param T
	 * 
	 * @return WhereClauseBuilder : Is QueryString Type T
	 * 
	 */
	protected abstract WhereClauseBuilder<T> getWhereClauseBuilder(T entity);

}
