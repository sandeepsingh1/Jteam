package com.hannover.helper;

import java.io.IOException;
import java.util.Properties;

import com.hannover.constants.ErrorMessages;
import com.hannover.constants.FileInitializationConstants;
import com.hannover.exception.RepositoryNotInitializedException;



/**
 * This class loads all the properties files.
 * 
 * @author piyush.mittal
 * 
 */
public class Repository {

	/**
	 * Logger Instance.
	 */

	/**
	 * To store the system.properties file.
	 */
	private Properties systemProps = null;

	/**
	 * To store the quartz.properties file.
	 */
	private Properties quartzProps = null;

	/**
	 * Singleton repository instance.
	 */
	private static Repository repository = null;

	/**
	 * Constructor.
	 */
	private Repository() {
		super();
		init();
	}

	/**
	 * Returns the singleton repository object.
	 * 
	 * @return
	 */
	public static Repository getRepository() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	/**
	 * initializes the repository object.
	 */
	public void init() {
		initSystem();
		initQuartz();
	}

	/**
	 * Reads the system.properties file.
	 */
	public void initSystem() {
		try {
			if (systemProps == null) {
				systemProps = ResourceToolkit
						.loadProperties(FileInitializationConstants.FILE_SYSTEM_INIT);
			}
		} catch (IOException e) {
			System.out.println(ErrorMessages.ERR_INITIALIZING_QUARTZ);
			systemProps = null;
		}
	}

	/**
	 * Returns the system.properties read data.
	 * 
	 * @param key
	 * @return
	 * @throws RepositoryNotInitializedException
	 */
	public String getSystemProperty(String key)
			throws RepositoryNotInitializedException {
		if (systemProps == null) {
			throw new RepositoryNotInitializedException(
					ErrorMessages.ERR_INITIALIZING_SYSTEM);
		}
		return systemProps.getProperty(key);
	}

	/**
	 * Reads the quartz.properties file.
	 */
	public void initQuartz() {
		try {
			if (quartzProps == null) {
				quartzProps = ResourceToolkit
						.loadProperties(FileInitializationConstants.FILE_QUARTZ_INIT);
			}
		} catch (IOException e) {
			System.out.println(ErrorMessages.ERR_INITIALIZING_QUARTZ);
			quartzProps = null;
		}
	}

	/**
	 * Returns the quartz.properties read data.
	 * 
	 * @param key
	 * @return
	 * @throws RepositoryNotInitializedException
	 */
	public String getQuartzProperty(String key)
			throws RepositoryNotInitializedException {
		if (quartzProps == null) {
			throw new RepositoryNotInitializedException(
					ErrorMessages.ERR_INITIALIZING_QUARTZ);
		}
		return quartzProps.getProperty(key);
	}

	public Properties getQuartzProperty()
			throws RepositoryNotInitializedException {
		if (quartzProps == null)
			throw new RepositoryNotInitializedException(
					ErrorMessages.ERR_INITIALIZING_QUARTZ);
		return quartzProps;
	}
}
