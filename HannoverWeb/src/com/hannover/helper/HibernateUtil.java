package com.hannover.helper;

import java.io.File;
import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * This is the hibernate utility class used for getting 
 * the session factory after loading the configuration file
 *
 */
public class HibernateUtil {
	/**
	 * Logger instance.
	 */
	/**
	 * Singleton object for sessionFactory.
	 */
	private static final SessionFactory factory = prepareSessionFactory();
	
	/**
	 * Loads the configuration file and returns the sessionFactory object.
	 * @return
	 */
	private static SessionFactory prepareSessionFactory(){
		SessionFactory sessionFactory = null;
		try{
			System.out.println("Configuring Hibernate session factory");
			//URL url = Thread.currentThread().getContextClassLoader().getResource("hibernate.cfg.xml");
			File f = new File("E:\\Hannover\\hibernate.cfg.xml"); 
			Configuration cfg = new AnnotationConfiguration();
			sessionFactory = cfg.configure(f).buildSessionFactory();
			System.out.println("Hibernate session factory configured");
		}
		catch(Throwable t){
			System.out.println(" Exception while prepareSessionFactory "+t);
			System.exit(0);
		}
		return sessionFactory;
	}
	
	/**
	 * Returns the session factory object.
	 * @return
	 */
	public static SessionFactory getSessionFactory(){
		return factory;
	}
 
	/**
	 * Returns the current session or creates a new session if no session exists.
	 * @return
	 */
	public static Session getCurrentSession(){
		if(factory.getCurrentSession().isOpen()){
			return factory.getCurrentSession();
		}
		return factory.openSession();
	}
 
	/**
	 * Creates a new session.
	 * @return
	 */
	public static Session openSession(){
		return factory.openSession();
	}

}
