package net.example.reporting.dao.tests;

import java.util.List;

import net.example.reporting.dao.ReportingDaoFactory;
import net.example.reporting.dao.entity.Pixel;
import net.example.reporting.dao.impl.PixelDAO;
import net.example.reporting.dao.interfaces.BaseDao;
import net.example.reporting.dao.interfaces.BaseEntity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PixelDAOTest {
	BaseDao pixelDao = null;
	@Before
	public void setup() throws Exception {
		pixelDao = ReportingDaoFactory.getInstance().getDAO(Pixel.class);
	}

	@Test(expected=Exception.class)
	public void testInsertFailure(){
		BaseEntity entity = new Pixel();
		pixelDao.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSave() throws Exception{
		int n = 100;
		for(long i=1;i<=n;i++){
			Pixel entity = new Pixel();
			entity.setPxId(i);
			entity.setIsPiggyback("yes");
			entity.setPxCount(i);
			entity.setMaxTime(10000);
			entity.setTimesFired(100);
			entity.setType(1);
			pixelDao.save(entity);
		}
		List<Pixel> advAll = pixelDao.getAll(Pixel.class);
		Assert.assertEquals(n, advAll.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAll(){
		List<Pixel> advList = pixelDao.getAll(Pixel.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDelete(){
		int tableSize0 = pixelDao.getAll(Pixel.class).size();
		Pixel entity = ((PixelDAO) pixelDao).getByPxId(1);
		pixelDao.delete(entity);
		Pixel entity1 = ((PixelDAO) pixelDao).getByPxId(1);
		int tableSize1 = pixelDao.getAll(Pixel.class).size();
		Assert.assertEquals(tableSize0-1,tableSize1);
		Assert.assertEquals(null, entity1);
	}
	
	@Test 
	public void testGetById(){
		Pixel entity = ((PixelDAO) pixelDao).getByPxId(2);
		Assert.assertNotNull(entity);
		Assert.assertEquals(2, entity.getPxId().intValue());
		Assert.assertEquals(10000, entity.getMaxTime());
		Assert.assertEquals(2, entity.getPxCount());
		Assert.assertEquals(100, entity.getTimesFired());
		Assert.assertEquals(1, entity.getType());
		Assert.assertEquals(2, entity.getPxId().longValue());
		Assert.assertEquals("yes", entity.getIsPiggyback());
		Assert.assertNotNull(entity.toString());
	}
	
	@After
	public void cleanUp(){
	}
}
