package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author pjaisw1
 * 
 */
@Entity
@Table(name = "POLICY")
public class PolicyRecord implements Serializable {
	
	private static final long serialVersionUID = -6883000843861296922L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "TENANT_ID")
	private String tenantId;

	@Column(name = "POLICY_NAME")
	private String policyName;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "REALM_NAME")
	private String realm_name;

	@Column(name = "POLICY_STRING")
	private String policyStr;

	@Column(name = "VERSION")
	private int version;

	public PolicyRecord() {
	}

	public PolicyRecord(String tenantId, String policyName, String appName,
			String realmName, String policyStr, int version) {
		this.tenantId = tenantId;
		this.policyName = policyName;
		this.appName = appName;
		this.realm_name = realmName;
		this.policyStr = policyStr;
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getRealmName() {
		return realm_name;
	}

	public void setRealmName(String realm_name) {
		this.realm_name = realm_name;
	}

	public String getPolicyStr() {
		return policyStr;
	}

	public void setPolicyStr(String policyStr) {
		this.policyStr = policyStr;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
