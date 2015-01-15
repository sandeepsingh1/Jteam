package com.hannover.exception;

/**
 * This exception wraps all the lookup exceptions while accessing a service bean
 * class instance through business interface.
 * @author piyush.mittal
 *
 */
public class ServiceLocatorException extends Exception{

	/**
	 * Serial Version for persistence.
	 */
	private static final long serialVersionUID = -2899052390998012535L;

	/**
	 * Default Constructor.
	 */
	public ServiceLocatorException(){
		super();
	}
	
	/**
	 * Constructor.
	 * @param message
	 */
	public ServiceLocatorException(String message){
		super(message);
	}
	
	/**
	 * Constructor.
	 * @param exception
	 */
	public ServiceLocatorException(Throwable exception){
		super(exception);
	}
	
	/**
	 * Constructor.
	 * @param message
	 * @param exception
	 */
	public ServiceLocatorException(String message, Throwable exception){
		super(message, exception);
	}
}
