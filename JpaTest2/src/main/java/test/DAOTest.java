package test;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PolicyDAO;
import entity.PolicyRecord;

public class DAOTest {
	public static void main(String [] args) {
		PolicyRecord pol = new PolicyRecord("tenantId", "policyName","appName", "realmName", "policyStr", 1);
		pol.setId(UUID.randomUUID().toString());
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		PolicyDAO pdao = appContext.getBean(PolicyDAO.class);
		pdao.save(pol);
	}
}
