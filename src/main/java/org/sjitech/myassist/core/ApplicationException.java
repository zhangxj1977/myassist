package org.sjitech.myassist.core;

/**
 * 
 * @author zhangxj1977
 *
 */
public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2514227516892907155L;

	/**
	 * 
	 */
	public ApplicationException() {
	}

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * @param t
	 */
	public ApplicationException(Throwable t) {
		super(t);
	}

	/**
	 * @param message
	 * @param arg1
	 */
	public ApplicationException(String message, Throwable t) {
		super(message, t);
	}

}
