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
 * reserved for javadoc
 */
public abstract class GenericORMDao<T> {

	@Inject
	SessionFactory sf;
	
	private static final Logger LOGGER = LogManager.getLogger(GenericORMDao.class);

	public final void create(T entity) {
		if (!beforeCreate(entity)) {
			return;
		}

		final Session session = sf.openSession();
		session.saveOrUpdate(entity);

	}

	protected boolean beforeCreate(T entity) {
		return entity != null;
	}

	public final void update(T entity) {
		final Session session = sf.openSession();
		session.saveOrUpdate(entity);
	}

	public final void delete(T entity) {
		final Session session = sf.openSession();
		session.delete(entity);
	}

	public final List<T> search(T entity) {
		Query searchQuery = null;
		Session session = null;
		try {
			session = sf.openSession();
			final WhereClauseBuilder<T> wcb = getWhereClauseBuilder(entity);
			searchQuery = session.createQuery(wcb.getQueryString());
			for (final Entry<String, Object> parameterEntry : wcb.getParameters().entrySet()) {
				searchQuery.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
			}

			
		} catch (Exception e) {
			LOGGER.error("Error while searching " + entity.getClass().getName(), e);
		} finally {
			if(session != null) {
				session.close();
			}
			
		}
		
		return searchQuery.list();
		
	}

	protected abstract WhereClauseBuilder<T> getWhereClauseBuilder(T entity);

}
