package info.sjd.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

class HibernateFactoryTest {


//	@Test
	public void testGetSessionFactory() {
		SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
		assertNotNull(sessionFactory);
		
		Session session = sessionFactory.openSession();
		assertNotNull(session);
		
		session.close();
	}
}
