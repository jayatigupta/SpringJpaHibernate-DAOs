package net.example.reporting.dao.impl;

import java.util.List;

import net.example.reporting.dao.HibernateUtil;
import net.example.reporting.dao.entity.Advertiser;
import net.example.reporting.dao.interfaces.BaseDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
/**
 * 
 * @author puneet
 *
 */
public class AdvertiserDAO extends BaseDao{
	/**
	 * This method returns one Object identified by the liId
	 * @param liId : advertiser li id
	 * @return : Advertiser identified by liId
	 */
	@SuppressWarnings("unchecked")
	public Advertiser getByLiId(long liId) {
		Session session = HibernateUtil.currentSession();
		Criteria crit = session.createCriteria(Advertiser.class);
		crit.add(Restrictions.eq("liId", liId));
		List<Advertiser> advertisers = crit.list();
		if (advertisers != null && advertisers.size() > 0) {
			Advertiser adv = advertisers.get(0);
			return adv;
		}
		return null;
	}
	
}
