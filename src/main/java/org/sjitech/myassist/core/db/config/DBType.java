package org.sjitech.myassist.core.db.config;

import org.sjitech.myassist.core.db.ConnectionInspect;
import org.sjitech.myassist.core.db.inspect.CommonConnectionInspect;
import org.sjitech.myassist.core.db.inspect.DB2ConnectionInspect;
import org.sjitech.myassist.core.db.inspect.OracleConnectionInspect;

/**
 * DB type
 * 
 * @author sji_zhang_x
 *
 */
public enum DBType {

	// common jdbc
	Common(CommonConnectionInspect.class, ""),
	// db2
	DB2(DB2ConnectionInspect.class, "com.ibm.db2.jcc.DB2Driver"),
	// oracle
	Oracle(OracleConnectionInspect.class, "oracle.jdbc.driver.OracleDriver");

    /**
     * inspect class 
     */
    private final Class<? extends ConnectionInspect> inspectClass;

    /**
     * default driver class name 
     */
    private final String driverClassName;

	/**
	 * @param newInspectClass
	 * @param newDriverClassName
	 */
	private DBType(Class<? extends ConnectionInspect> newInspectClass,
			String newDriverClassName) {
		this.inspectClass = newInspectClass;
		this.driverClassName = newDriverClassName;
	}

	/**
	 * @return
	 */
	public Class<? extends ConnectionInspect> getInspectClass() {
		return inspectClass;
	}

	/**
	 * @return driverClassName
	 */
	public String getDriverClassName() {
		return driverClassName;
	}

}