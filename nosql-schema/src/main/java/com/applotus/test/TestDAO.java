package com.applotus.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.applotus.util.SchemaStore;

public class TestDAO {

    public static void main(String[] args) {
	// String var = System.currentTimeMillis()+"";
	Map<String, Object> nestedMap = new HashMap<>();
	nestedMap.put("id1", "1");
	nestedMap.put("id2", "2");
	nestedMap.put("id3", "3");
	Map<String, String> address = new HashMap<>();
	address.put("Street", "167 Fair oks");
	address.put("City", "San Francisco");

	nestedMap.put("Address", address);

	ApplicationContext appContext = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	SchemaStore ss = appContext.getBean(SchemaStore.class);
	ss.saveFields("id", nestedMap);
	Map<String, Object> data = ss.getData("id");
	System.out.println(data);
    }
}
