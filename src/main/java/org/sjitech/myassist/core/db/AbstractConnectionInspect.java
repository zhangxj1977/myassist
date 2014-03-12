package org.sjitech.myassist.core.db;

import java.sql.Connection;

/**
 * @author zhangxj1977
 *
 */
public abstract class AbstractConnectionInspect implements ConnectionInspect {

	/**
	 * real connection associate database
	 */
	protected Connection connection = null;

	/**
	 * @param conn
	 */
	public AbstractConnectionInspect(Connection conn) {
		this.connection = conn;
	}

}
