package de.htwg.tetris.model.hibernate.persistent;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static {
		final AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	private HibernateUtil() {	}
	
	public static SessionFactory getInstance() {
		return sessionFactory;
	}

}
