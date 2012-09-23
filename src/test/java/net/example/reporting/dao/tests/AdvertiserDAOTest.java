package net.example.reporting.dao.tests;

import java.util.List;

import net.example.reporting.dao.ReportingDaoFactory;
import net.example.reporting.dao.entity.Advertiser;
import net.example.reporting.dao.impl.AdvertiserDAO;
import net.example.reporting.dao.interfaces.BaseDao;
import net.example.reporting.dao.interfaces.BaseEntity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author puneet
 *
 */
public class AdvertiserDAOTest {
	BaseDao advDao = null;
	@Before
	public void setup() throws Exception {
		advDao = ReportingDaoFactory.getInstance().getDAO(Advertiser.class);
	}

	@Test(expected=Exception.class)
	public void testInsertFailure(){
		BaseEntity entity = new Advertiser();
		advDao.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSave() throws Exception{
		int n = 100;
		for(int i=1;i<=n;i++){
			Advertiser entity = new Advertiser();
			entity.setAdvertiserId(i);
			entity.setLiId(i);
			entity.setAdvertiserName(i+" name");
			entity.setCurrencyId(1);
			entity.setStartTime(System.currentTimeMillis()/1000);
			entity.setEndTime(System.currentTimeMillis()/1000);
			entity.setIoCurrencyId(1);
			entity.setIoId(2);
			entity.setIoName("IO name " + i );
			entity.setIoRegionId(2);
			entity.setLiBudget("liBudget");
			entity.setLicenseeId(2);
			entity.setLiName("liName" + i);
			advDao.save(entity);
			Advertiser entity1 = ((AdvertiserDAO) advDao).getByLiId(i);
			Assert.assertEquals(entity.getLiId(), entity1.getLiId());
			Assert.assertEquals(entity.getAdvertiserId(), entity1.getAdvertiserId());
			Assert.assertEquals(entity.getAdvertiserName(), entity1.getAdvertiserName());
			Assert.assertEquals(entity.getCurrencyId(), entity1.getCurrencyId());
			Assert.assertEquals(entity.getEndTime(), entity1.getEndTime());
			Assert.assertEquals(entity.getIoCurrencyId(), entity1.getIoCurrencyId());
			Assert.assertEquals(entity.getIoId(), entity1.getIoId());
			Assert.assertEquals(entity.getIoName(), entity1.getIoName());
			Assert.assertEquals(entity.getIoRegionId(), entity1.getIoRegionId());
			Assert.assertEquals(entity.getLiBudget(), entity1.getLiBudget());
			Assert.assertEquals(entity.getLicenseeId(), entity1.getLicenseeId());
			Assert.assertEquals(entity.getLiName(), entity1.getLiName());
			Assert.assertEquals(entity.getPricingType(), entity1.getPricingType());
			Assert.assertEquals(entity.getStartTime(), entity1.getStartTime());
		}
		List<Advertiser> advAll = advDao.getAll(Advertiser.class);
		Assert.assertEquals(n, advAll.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAll(){
		List<Advertiser> advList = advDao.getAll(Advertiser.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDelete(){
		int tableSize0 = advDao.getAll(Advertiser.class).size();
		Advertiser entity = ((AdvertiserDAO) advDao).getByLiId(1);
		advDao.delete(entity);
		Advertiser entity1 = ((AdvertiserDAO) advDao).getByLiId(1);
		int tableSize1 = advDao.getAll(Advertiser.class).size();
		Assert.assertEquals(tableSize0-1,tableSize1);
		Assert.assertEquals(null, entity1);
		Assert.assertNotNull(entity.toString());
	}
	
	@Test 
	public void testGetById(){
		Advertiser entity = ((AdvertiserDAO) advDao).getByLiId(2);
		Assert.assertNotNull(entity);
		Assert.assertEquals(2, entity.getLiId());
	}
	
	@After
	public void cleanUp(){
	}
}