package dao;

import model.PolicyRecord;

/**
 * 
 * @author pjaisw1
 *
 */
public class PolicyDAO extends AbstractDAO<PolicyRecord> {

	public PolicyDAO() {
		this.setClazz(PolicyRecord.class);
	}
}
