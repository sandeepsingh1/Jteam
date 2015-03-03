package com.hannover.helper;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.hannover.exception.RepositoryNotInitializedException;
import com.hannover.exception.ServiceLocatorException;


public class ServiceLocator {

	private static ServiceLocator serviceLocator;

	/**
	 * Initial Context.
	 */
	private InitialContext context = null;
	
	/**
	 * Constructor
	 * @throws ServiceLocatorException
	 */
	private ServiceLocator() throws ServiceLocatorException {
		Hashtable<String,String> env = new Hashtable<String,String>();
		try{
			env.put("java.naming.factory.initial",
					Repository.getRepository().getSystemProperty("java.naming.factory.initial"));
			env.put("java.naming.provider.url", 
					Repository.getRepository().getSystemProperty("java.naming.provider.url"));
		}
		catch(RepositoryNotInitializedException ex){
			throw new ServiceLocatorException(ex);
		}
		initLocator(env);
	}
	
	/**
	 * Constructor.
	 */
	private ServiceLocator(Hashtable<String,String> env) throws ServiceLocatorException {
		initLocator(env);
	}
	
	/**
	 * Gets an initial context object.
	 * @param env
	 * @throws ServiceLocatorException
	 */
	private void initLocator(Hashtable<String,String> env) throws ServiceLocatorException {
		try {
			context = new InitialContext(env);
		} 
		catch (NamingException ne) {
			throw new ServiceLocatorException(ne);
		}
	}

	/**
	 * Returns the service locator single instance.
	 * @return
	 * @throws ServiceLocatorException
	 */
	public static ServiceLocator getInstance() throws ServiceLocatorException {
		if (serviceLocator == null) {
			serviceLocator = new ServiceLocator();
		}
		return serviceLocator;
	}

	/**
	 * Returns the service locator single instance.
	 * @param env
	 * @return
	 * @throws ServiceLocatorException
	 */
	public static ServiceLocator getInstance(Hashtable<String,String> env) throws ServiceLocatorException {
		if (serviceLocator == null) {
			serviceLocator = new ServiceLocator(env);
		}
		return serviceLocator;
	}

	/**
	 * Returns the remote interface object.
	 * @param jndiName
	 * @return
	 * @throws ServiceLocatorException
	 */
	public Object getRemoteService(String jndiName) throws ServiceLocatorException {
		Object objref;
		try {
			objref = context.lookup(jndiName);
			return objref;
		} catch (NamingException ex) {
			throw new ServiceLocatorException(ex);
		}
	}
}
