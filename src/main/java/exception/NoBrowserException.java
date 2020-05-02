package exception;

/**
 * Exception thrown when no browser configurated
 * 
 * @author jaramend
 *
 */
public class NoBrowserException extends Exception {

	private static final long serialVersionUID = 7533855187449376490L;

	public NoBrowserException(String message) {
		super(message);
	}
}
