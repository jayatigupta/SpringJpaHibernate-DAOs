package net.example.reporting.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import net.example.reporting.dao.HibernateUtil;
import net.example.reporting.dao.entity.Creative;
import net.example.reporting.dao.interfaces.BaseDao;

/**
 * 
 * @author puneet
 *
 */
public class CreativeDAO extends BaseDao{
	@SuppressWarnings("unchecked")
	public Creative getByCrId(long creativeId) {
		Session session = HibernateUtil.currentSession();
		Criteria crit = session.createCriteria(Creative.class);
		crit.add(Restrictions.eq("crId", creativeId));
		List<Creative> crs = crit.list();
		if (crs != null && crs.size() > 0) {
			Creative cr = crs.get(0);
			return cr;
		}
		return null;
	}

}
