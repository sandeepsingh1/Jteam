package com.hannover.constants;

/**
 * Constants for defining the file locations and initialization constants.
 * @author Piyush.Mittal
 *
 */
public interface FileInitializationConstants {
    /**
     * Hibernate Configuration file location.
     */
	public static final String HIBERNATE_CONF_FILE = "/conf/hibernate.cfg.xml";
	
	/**
	 * Hibernate Configuration file location for Staging server
	 */
	public static final String HIBERNATE_STAGING_CONF_FILE = "/conf/hibernate.staging.cfg.xml";
	/**
	 * System.properties file location.
	 */
	public static final String FILE_SYSTEM_INIT = "conf/system.properties";

	/**
	 * quartz.properties file location.
	 */
	public static final String FILE_QUARTZ_INIT = "conf/quartz.properties";

	/**
	 * Log4j configuration.
	 * Used in InitServlet
	 */
	public static final long LOG4J_WATCH_DELAY = 60000;
	public static final String FILE_LOG4J_INIT = "/conf/novalog4j.properties";
	public static final String ERR_INITIALIZING_LOG4J = "Could not configure Logger. Log Messages will out in Standard out. Please correct the configuration.";
	public static final String SUCCESS_LOG4J_INIT = "Log4j System Configured Successfully.";
	public static final String SUCCESS_SCHEDULER_START = "Scheduler Service Started Successfully.";
	public static final String ERR_STARTING_SCHEDULER = "Could not start Scheduler Service.";
}
