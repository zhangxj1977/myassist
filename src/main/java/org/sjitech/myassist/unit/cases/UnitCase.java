package org.sjitech.myassist.unit.cases;

import java.sql.Timestamp;


/**
 * identify one test case
 * 
 * @author sji_zhang_x
 *
 */
public class UnitCase {

	/**
	 * unit catagory
	 */
	private String catagory = null;

	/**
	 * unit case no
	 */
	private String unitCaseNo = null;

	/**
	 * unit class name
	 */
	private String unitClassName = null;

	/**
	 * test method name
	 */
	private String methodName = null;

	/**
	 * method's param
	 */
	private Params params = null;

	/**
	 * test result
	 */
	private Result expectedResult = null;

	/**
	 * method invoke result
	 */
	private Result invokedResult = null;

	/**
	 * when the case be executed 
	 */
	private Timestamp invokedTime = null;

	/**
	 * if the result be confirmed ok 
	 */
	private boolean isConfirmed = false;

	/**
	 * @return catagory
	 */
	public String getCatagory() {
		return catagory;
	}

	/**
	 * @param catagory セットする catagory
	 */
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	/**
	 * @return unitCaseNo
	 */
	public String getUnitCaseNo() {
		return unitCaseNo;
	}

	/**
	 * @param unitCaseNo セットする unitCaseNo
	 */
	public void setUnitCaseNo(String unitCaseNo) {
		this.unitCaseNo = unitCaseNo;
	}

	/**
	 * @return unitClassName
	 */
	public String getUnitClassName() {
		return unitClassName;
	}

	/**
	 * @param unitClassName セットする unitClassName
	 */
	public void setUnitClassName(String unitClassName) {
		this.unitClassName = unitClassName;
	}

	/**
	 * @return methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @param methodName セットする methodName
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * @return params
	 */
	public Params getParams() {
		return params;
	}

	/**
	 * @param params セットする params
	 */
	public void setParams(Params params) {
		this.params = params;
	}

	/**
	 * @return expectedResult
	 */
	public Result getExpectedResult() {
		return expectedResult;
	}

	/**
	 * @param expectedResult セットする expectedResult
	 */
	public void setExpectedResult(Result expectedResult) {
		this.expectedResult = expectedResult;
	}

	/**
	 * @return invokedResult
	 */
	public Result getInvokedResult() {
		return invokedResult;
	}

	/**
	 * @param invokedResult セットする invokedResult
	 */
	public void setInvokedResult(Result invokedResult) {
		this.invokedResult = invokedResult;
	}

	/**
	 * @return invokedTime
	 */
	public Timestamp getInvokedTime() {
		return invokedTime;
	}

	/**
	 * @param invokedTime セットする invokedTime
	 */
	public void setInvokedTime(Timestamp invokedTime) {
		this.invokedTime = invokedTime;
	}

	/**
	 * @return isConfirmed
	 */
	public boolean isConfirmed() {
		return isConfirmed;
	}

	/**
	 * @param isConfirmed セットする isConfirmed
	 */
	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
}
