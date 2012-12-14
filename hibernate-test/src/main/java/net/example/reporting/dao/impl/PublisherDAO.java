package net.example.reporting.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import net.example.reporting.dao.HibernateUtil;
import net.example.reporting.dao.entity.Publisher;
import net.example.reporting.dao.interfaces.BaseDao;
/**
 * 
 * @author puneet
 *
 */
public class PublisherDAO extends BaseDao{

	@SuppressWarnings("unchecked")
	public Publisher getByLiId(long liId) {
		Session session = HibernateUtil.currentSession();
		Criteria crit = session.createCriteria(Publisher.class);
		crit.add(Restrictions.eq("liId", liId));
		List<Publisher> ps = crit.list();
		if (ps!= null && ps.size() > 0) {
			Publisher p = ps.get(0);
			return p;
		}
		return null;
	}
	
}
