package test;

import java.util.List;
import java.util.UUID;

import model.PolicyRecord;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PolicyDAO;

public class TestMain {

	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("iam-bizmgr-config.xml");
		
		PolicyDAO polDao = appContext.getBean(PolicyDAO.class);
		
		PolicyRecord pol = new PolicyRecord("tenantId", "policyName","appName", "realmName", "policyStr", 1);
		pol.setId(UUID.randomUUID().toString());
		polDao.save(pol);
		List<PolicyRecord> plist=polDao.findAll();
		System.out.println(plist.size());
	}
}
