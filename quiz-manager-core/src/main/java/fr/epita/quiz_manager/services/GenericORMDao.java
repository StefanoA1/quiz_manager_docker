package fr.epita.quiz_manager.services;

import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 * reserved for javadoc
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

	protected abstract WhereClauseBuilder<T> getWhereClauseBuilder(T entity);

}
