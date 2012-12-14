package net.example.reporting.dao;

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
/**
 * 
 * @author puneet
 *
 */
public class ReportingDaoFactory {

	private static final ReportingDaoFactory instance = new ReportingDaoFactory();
	private ReportingDaoFactory(){}
	
	public static ReportingDaoFactory getInstance(){
		return instance;
	}
	
	/**
	 * This factory method returns DAO object for given entity class
	 * @param entityClazz  : Entity class
	 * @return : DAO object for the Entity Class
	 * @throws Exception : if given entity class is not found
	 */
	@SuppressWarnings("rawtypes")
	public BaseDao getDAO(final Class entityClazz) throws Exception{
		if(entityClazz.equals(Advertiser.class)) {
			return new AdvertiserDAO();
		}
		if(entityClazz.equals(Creative.class)){
			return new CreativeDAO();
		}
		if(entityClazz.equals(Pixel.class)){
			return new PixelDAO();
		}
		if(entityClazz.equals(Publisher.class)){
			return new PublisherDAO();
		}
		if(entityClazz.equals(Segment.class)){
			return new SegmentDAO();
		}
		throw new Exception("DAO not found for entity " + entityClazz.getName());
	}
}
