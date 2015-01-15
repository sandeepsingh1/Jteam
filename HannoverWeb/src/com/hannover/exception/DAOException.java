package com.hannover.exception;

/**
 * This exception captures all the database update operation failures.
 * @author Piyush.Mittal
 *
 */
public class DAOException extends Exception{

	/**
	 * Serial Version for persistence.
	 */
	private static final long serialVersionUID = 2682355524969153942L;

	/**
	 * Default Constructor.
	 */
	public DAOException(){
		super();
	}
	
	/**
	 * Constructor.
	 * @param message
	 */
	public DAOException(String message){
		super(message);
	}
	
	/**
	 * Constructor.
	 * @param exception
	 */
	public DAOException(Throwable exception){
		super(exception);
	}
	
	/**
	 * Constructor.
	 * @param message
	 * @param exception
	 */
	public DAOException(String message, Throwable exception){
		super(message, exception);
	}
}
