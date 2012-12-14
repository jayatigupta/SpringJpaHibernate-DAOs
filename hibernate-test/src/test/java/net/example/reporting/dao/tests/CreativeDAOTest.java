package net.example.reporting.dao.tests;

import java.util.List;

import net.example.reporting.dao.ReportingDaoFactory;
import net.example.reporting.dao.entity.Creative;
import net.example.reporting.dao.impl.CreativeDAO;
import net.example.reporting.dao.interfaces.BaseDao;
import net.example.reporting.dao.interfaces.BaseEntity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreativeDAOTest {
	BaseDao creativeDao = null;
	@Before
	public void setup() throws Exception {
		creativeDao = ReportingDaoFactory.getInstance().getDAO(Creative.class);
	}

	@Test (expected=Exception.class)
	public void testInsertFailure(){
		BaseEntity entity = new Creative();
		creativeDao.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSave() throws Exception{
		int n = 100;
		for(int i=1;i<=n;i++){
			Creative entity = new Creative();
			entity.setCrId(i);
			entity.setHeight(i+2);
			entity.setIsPopUp("yes");
			entity.setName("creative "+i);
			entity.setType("cr type");
			entity.setUrl("http://komli.com/creative"+i);
			entity.setCreative_width(i);
			creativeDao.save(entity);
		}
		List<Creative> advAll = creativeDao.getAll(Creative.class);
		Assert.assertEquals(n, advAll.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAll(){
		List<Creative> advList = creativeDao.getAll(Creative.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDelete(){
		int tableSize0 = creativeDao.getAll(Creative.class).size();
		Creative entity = ((CreativeDAO) creativeDao).getByCrId(1L);
		creativeDao.delete(entity);
		Creative entity1 = ((CreativeDAO) creativeDao).getByCrId(1);
		int tableSize1 = creativeDao.getAll(Creative.class).size();
		Assert.assertEquals(tableSize0-1,tableSize1);
		Assert.assertEquals(null, entity1);
		Assert.assertNotNull(entity.toString());
	}
	
	@Test 
	public void testGetById(){
		Creative entity = ((CreativeDAO) creativeDao).getByCrId(2);
		Assert.assertNotNull(entity);
		Assert.assertEquals(2, entity.getCrId());
		Assert.assertEquals(2, entity.getCreative_width());
		Assert.assertEquals(2+2, entity.getHeight());
		Assert.assertEquals("yes", entity.getIsPopUp());
		Assert.assertEquals("creative "+2, entity.getName());
		Assert.assertEquals("cr type", entity.getType());
		Assert.assertEquals("http://komli.com/creative"+2, entity.getUrl());
	}
	
	@After
	public void cleanUp(){
	}
}
