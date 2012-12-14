package net.example.reporting.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import net.example.reporting.dao.HibernateUtil;
import net.example.reporting.dao.entity.Segment;
import net.example.reporting.dao.interfaces.BaseDao;
/**
 * 
 * @author puneet
 *
 */
public class SegmentDAO extends BaseDao {

	@SuppressWarnings("unchecked")
	public Segment getBySegId(long segId) {
		Session session = HibernateUtil.currentSession();
		Criteria crit = session.createCriteria(Segment.class);
		crit.add(Restrictions.eq("segId", segId));
		List<Segment> segs = crit.list();
		if (segs!= null && segs.size() > 0) {
			Segment seg = segs.get(0);
			return seg;
		}
		return null;
	}
	
}