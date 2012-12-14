package net.example.reporting.dao.tests;

import java.util.List;

import net.example.reporting.dao.ReportingDaoFactory;
import net.example.reporting.dao.entity.Advertiser;
import net.example.reporting.dao.entity.Creative;
import net.example.reporting.dao.entity.Pixel;
import net.example.reporting.dao.entity.Publisher;
import net.example.reporting.dao.entity.Segment;
import net.example.reporting.dao.impl.AdvertiserDAO;
import net.example.reporting.dao.impl.CreativeDAO;
import net.example.reporting.dao.impl.PixelDAO;
import net.example.reporting.dao.impl.PublisherDAO;
import net.example.reporting.dao.impl.SegmentDAO;
import net.example.reporting.dao.interfaces.BaseDao;
import net.example.reporting.dao.interfaces.BaseEntity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportingDAOTests {
	BaseDao advDao = null;
	BaseDao creativeDao = null;
	BaseDao pixelDao = null;
	BaseDao pubDao = null;
	BaseDao segDao = null;

	@Before
	public void setup() throws Exception {
		advDao = ReportingDaoFactory.getInstance().getDAO(Advertiser.class);
		creativeDao = ReportingDaoFactory.getInstance().getDAO(Creative.class);
		pixelDao = ReportingDaoFactory.getInstance().getDAO(Pixel.class);
		pubDao = ReportingDaoFactory.getInstance().getDAO(Publisher.class);
		segDao = ReportingDaoFactory.getInstance().getDAO(Segment.class);
	}

	@Test(expected=Exception.class)
	public void testInsertFailureAdao(){
		BaseEntity entity = new Advertiser();
		advDao.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSaveAdao() throws Exception{
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
	public void testGetAllAdao(){
		List<Advertiser> advList = advDao.getAll(Advertiser.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDeleteAdao(){
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
	public void testGetByIdADao(){
		Advertiser entity = ((AdvertiserDAO) advDao).getByLiId(2);
		Assert.assertNotNull(entity);
		Assert.assertEquals(2, entity.getLiId());
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSaveCDao() throws Exception{
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
	public void testGetAllCDao(){
		List<Creative> advList = creativeDao.getAll(Creative.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDeleteCDao(){
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
	public void testGetByIdCdao(){
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
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSavePDao() throws Exception{
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
	public void testGetAllPDao(){
		List<Pixel> advList = pixelDao.getAll(Pixel.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDeletePDao(){
		int tableSize0 = pixelDao.getAll(Pixel.class).size();
		Pixel entity = ((PixelDAO) pixelDao).getByPxId(1);
		pixelDao.delete(entity);
		Pixel entity1 = ((PixelDAO) pixelDao).getByPxId(1);
		int tableSize1 = pixelDao.getAll(Pixel.class).size();
		Assert.assertEquals(tableSize0-1,tableSize1);
		Assert.assertEquals(null, entity1);
	}
	
	@Test 
	public void testGetByIdPDao(){
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
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSavePubDao() throws Exception{
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
	public void testGetAllPubDao(){
		List<Publisher> advList = pubDao.getAll(Publisher.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDeletePubDao(){
		int tableSize0 = pubDao.getAll(Publisher.class).size();
		Publisher entity = ((PublisherDAO) pubDao).getByLiId(1);
		pubDao.delete(entity);
		Publisher entity1 = ((PublisherDAO) pubDao).getByLiId(1);
		int tableSize1 = pubDao.getAll(Publisher.class).size();
		Assert.assertEquals(tableSize0-1,tableSize1);
		Assert.assertEquals(null, entity1);
	}
	
	@Test 
	public void testGetByIdPubDao(){
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
	@SuppressWarnings("unchecked")
	@Test
	public void testSaveSegDao() throws Exception{
		int n = 100;
		for(int i=1;i<=n;i++){
			Segment entity = new Segment();
			entity.setSegId(i);
			entity.setName("segment "+i);
			segDao.save(entity);
		}
		List<Segment> advAll = segDao.getAll(Segment.class);
		Assert.assertEquals(n, advAll.size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAllSegDao(){
		List<Segment> advList = segDao.getAll(Segment.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDeleteSegDao(){
		int tableSize0 = segDao.getAll(Segment.class).size();
		Segment entity = ((SegmentDAO) segDao).getBySegId(1);
		segDao.delete(entity);
		Segment entity1 = ((SegmentDAO) segDao).getBySegId(1);
		int tableSize1 = segDao.getAll(Segment.class).size();
		Assert.assertEquals(tableSize0-1,tableSize1);
		Assert.assertEquals(null, entity1);
	}
	
	@Test 
	public void testGetByIdSegDao(){
		Segment entity = ((SegmentDAO) segDao).getBySegId(2);
		Assert.assertNotNull(entity);
		Assert.assertEquals(2, entity.getSegId());
		Assert.assertNotNull(entity.toString());
		Assert.assertEquals("segment "+2, entity.getName());
	}
	
	@After
	public void cleanUp(){
	}
}
