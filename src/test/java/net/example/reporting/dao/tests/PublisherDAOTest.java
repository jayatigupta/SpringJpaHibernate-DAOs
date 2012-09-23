package net.example.reporting.dao.tests;

import java.util.List;

import net.example.reporting.dao.ReportingDaoFactory;
import net.example.reporting.dao.entity.Publisher;
import net.example.reporting.dao.impl.PublisherDAO;
import net.example.reporting.dao.interfaces.BaseDao;
import net.example.reporting.dao.interfaces.BaseEntity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PublisherDAOTest {
	BaseDao pubDao = null;
	@Before
	public void setup() throws Exception {
		pubDao = ReportingDaoFactory.getInstance().getDAO(Publisher.class);
	}

	@Test(expected=Exception.class)
	public void testInsertFailure(){
		BaseEntity entity = new Publisher();
		pubDao.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSave() throws Exception{
		int n = 100;
		for(int i=1;i<=n;i++){
			Publisher entity = new Publisher();
			entity.setPublisherId(i);
			entity.setLiId(i);
			entity.setPublisherName(i+" name");
			entity.setIoId(2);
			entity.setIoName("IO name " + i);
			entity.setLicenseeId(2);
			entity.setLiName("liName" + i);
			entity.setPricingType(i);
			pubDao.save(entity);
		}
		List<Publisher> pubAll = pubDao.getAll(Publisher.class);
		Assert.assertEquals(n, pubAll.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAll(){
		List<Publisher> advList = pubDao.getAll(Publisher.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDelete(){
		int tableSize0 = pubDao.getAll(Publisher.class).size();
		Publisher entity = ((PublisherDAO) pubDao).getByLiId(1);
		pubDao.delete(entity);
		Publisher entity1 = ((PublisherDAO) pubDao).getByLiId(1);
		int tableSize1 = pubDao.getAll(Publisher.class).size();
		Assert.assertEquals(tableSize0-1,tableSize1);
		Assert.assertEquals(null, entity1);
	}
	
	@Test 
	public void testGetById(){
		Publisher entity = ((PublisherDAO) pubDao).getByLiId(2);
		Assert.assertNotNull(entity);
		Assert.assertEquals(2, entity.getLiId());
		Assert.assertNotNull(entity.toString());
		Assert.assertEquals(2, entity.getIoId());
		Assert.assertEquals(2, entity.getLicenseeId());
		Assert.assertEquals(2, entity.getLiId());
		Assert.assertEquals(2, entity.getPricingType());
		Assert.assertEquals(2, entity.getPublisherId());
		Assert.assertEquals("IO name " + 2, entity.getIoName());
		Assert.assertEquals("liName" + 2, entity.getLiName());
		Assert.assertEquals(2+" name", entity.getPublisherName());		
	}
	
	@After
	public void cleanUp(){
	}
}
