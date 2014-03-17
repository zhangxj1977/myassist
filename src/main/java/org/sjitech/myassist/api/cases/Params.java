package org.sjitech.myassist.api.cases;

/**
 * identify a method param
 * 
 * @author sji_zhang_x
 *
 */
public class Params {

	/**
	 * context value to be used
	 */
	private Object context = null;

	/**
	 * param object arrays
	 */
	private Object[] paramValues = null;

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
	 * @return paramValues
	 */
	public Object[] getParamValues() {
		return paramValues;
	}

	/**
	 * @param paramValues セットする paramValues
	 */
	public void setParamValues(Object[] paramValues) {
		this.paramValues = paramValues;
	}

}
