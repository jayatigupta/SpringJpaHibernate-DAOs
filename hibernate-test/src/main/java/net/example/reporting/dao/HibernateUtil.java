package net.example.reporting.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author puneet
 *
 */
public class HibernateUtil {
	public static final SessionFactory sessionFact;
	@SuppressWarnings("rawtypes")
	
	private static final ThreadLocal threadSession = new ThreadLocal();
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
	
	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFact = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			LOGGER.error("SessionFactory creation failed." , e);
			throw new ExceptionInInitializerError(e);
		}
	}

	@SuppressWarnings("unchecked")
	public synchronized static Session currentSession() throws HibernateException {
		Session session = (Session) threadSession.get();
		// Open a new Session, if this thread has none yet
		if (session == null || !session.isOpen()) {
			session = sessionFact.openSession();
			// Store it in the ThreadLocal variable
			threadSession.set(session);
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	public static void SessionClose() throws Exception {
		Session s = (Session) threadSession.get();
		if (s != null)
			s.close();
		threadSession.set(null);
	}

	
	@SuppressWarnings("rawtypes")
	public static Session createSession(final Class clazz) {
		return new Configuration().configure().addAnnotatedClass(clazz).buildSessionFactory().openSession();
	}

}