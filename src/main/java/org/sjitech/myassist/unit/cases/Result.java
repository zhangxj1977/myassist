package org.sjitech.myassist.unit.cases;

/**
 * identify a method invoke result
 * 
 * @author sji_zhang_x
 *
 */
public class Result {

	/**
	 * method return
	 */
	private Object result = null;

	/**
	 * context value to be setted
	 */
	private Object context = null;

	/**
	 * if exception happened with the method invoke 
	 */
	private Throwable exception = null;

	/**
	 * @return result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result セットする result
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return context
	 */
	public Object getContext() {
		return context;
	}

	/**
	 * @param context セットする context
	 */
	public void setContext(Object context) {
		this.context = context;
	}

	/**
	 * @return exception
	 */
	public Throwable getException() {
		return exception;
	}

	/**
	 * @param exception セットする exception
	 */
	public void setException(Throwable exception) {
		this.exception = exception;
	}

}
