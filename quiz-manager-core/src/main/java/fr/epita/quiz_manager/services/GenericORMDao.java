package fr.epita.quiz_manager.services;

import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * reserved for javadoc
 */
public abstract class GenericORMDao<T> {

	@Inject
	SessionFactory sf;

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
		final Session session = sf.openSession();
		final WhereClauseBuilder<T> wcb = getWhereClauseBuilder(entity);
		final Query searchQuery = session.createQuery(wcb.getQueryString());
		for (final Entry<String, Object> parameterEntry : wcb.getParameters().entrySet()) {
			searchQuery.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
		}

		return searchQuery.list();
	}

	protected abstract WhereClauseBuilder getWhereClauseBuilder(T entity);

}
