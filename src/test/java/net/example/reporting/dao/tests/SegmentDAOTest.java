package net.example.reporting.dao.tests;

import java.util.List;

import net.example.reporting.dao.ReportingDaoFactory;
import net.example.reporting.dao.entity.Segment;
import net.example.reporting.dao.impl.SegmentDAO;
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
public class SegmentDAOTest {
	BaseDao segDao = null;
	@Before
	public void setup() throws Exception {
		segDao = ReportingDaoFactory.getInstance().getDAO(Segment.class);
	}

	@Test(expected=Exception.class)
	public void testInsertFailure(){
		BaseEntity entity = new Segment();
		segDao.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSave() throws Exception{
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
	public void testGetAll(){
		List<Segment> advList = segDao.getAll(Segment.class);
		Assert.assertEquals(100, advList.size());
	}
	
	@Test
	public void testDelete(){
		int tableSize0 = segDao.getAll(Segment.class).size();
		Segment entity = ((SegmentDAO) segDao).getBySegId(1);
		segDao.delete(entity);
		Segment entity1 = ((SegmentDAO) segDao).getBySegId(1);
		int tableSize1 = segDao.getAll(Segment.class).size();
		Assert.assertEquals(tableSize0-1,tableSize1);
		Assert.assertEquals(null, entity1);
	}
	
	@Test 
	public void testGetById(){
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
