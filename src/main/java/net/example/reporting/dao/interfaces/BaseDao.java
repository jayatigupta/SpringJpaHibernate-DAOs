package net.example.reporting.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

import net.example.reporting.dao.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author puneet
 * 
 */
public abstract class BaseDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);

	public void save(BaseEntity entity) {
		Session session = HibernateUtil.currentSession();
		Transaction txn = session.beginTransaction();
		try {
			session.saveOrUpdate(entity);
		} catch (Exception e) {
			LOGGER.error("Entity save failed", e);
			throw new HibernateException("Entity save failed", e);
		} finally {
			txn.commit();
			session.flush();
			session.close();
		}
	}

	public void delete(BaseEntity entity) {
		Session session = HibernateUtil.currentSession();
		Transaction txn = session.beginTransaction();
		try {
			session.delete(entity);
		} catch (Exception e) {
			LOGGER.error("Entity delete failed", e);
		} finally {
			txn.commit();
			session.flush();
			session.close();
		}
	}

	@SuppressWarnings("rawtypes")
	@Deprecated
	public List getAll(Class clazz) {
		Session session = HibernateUtil.currentSession();
		Criteria crit = session.createCriteria(clazz);
		List list = crit.list();
		if (list != null)
			return list;
		else
			return new ArrayList<BaseEntity>();
	}
}
