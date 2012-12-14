 package net.example.reporting.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import net.example.reporting.dao.HibernateUtil;
import net.example.reporting.dao.entity.Pixel;
import net.example.reporting.dao.interfaces.BaseDao;
/**
 * 
 * @author puneet
 *
 */
public class PixelDAO extends BaseDao {
	
	@SuppressWarnings("unchecked")
	public Pixel getByPxId(long pxId) {
		Session session = HibernateUtil.currentSession();
		Criteria crit = session.createCriteria(Pixel.class);
		crit.add(Restrictions.eq("pxId", pxId));
		List<Pixel> pxs = crit.list();
		if (pxs != null && pxs.size() > 0) {
			Pixel px = pxs.get(0);
			return px;
		}
		return null;
	}
}
