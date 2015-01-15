package com.hannover.exception;

/**
 * This class wraps all the exceptions during the initial loading of the 
 * various properties files.
 * @author piyush.mittal
 *
 */
public class RepositoryNotInitializedException extends Exception{

	/**
	 * Serial Version for persistence.
	 */
	private static final long serialVersionUID = 5756074232525312315L;

	/**
	 * Default Constructor.
	 */
	public RepositoryNotInitializedException(){
		super();
	}
	
	/**
	 * Constructor.
	 * @param message
	 */
	public RepositoryNotInitializedException(String message){
		super(message);
	}
	
	/**
	 * Constructor.
	 * @param exception
	 */
	public RepositoryNotInitializedException(Throwable exception){
		super(exception);
	}
	
	/**
	 * Constructor.
	 * @param message
	 * @param exception
	 */
	public RepositoryNotInitializedException(String message, Throwable exception){
		super(message, exception);
	}
}
