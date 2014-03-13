package org.sjitech.myassist.core.db.inspect;

import java.sql.Connection;
import java.sql.SQLException;

import org.sjitech.myassist.core.ApplicationException;
import org.sjitech.myassist.core.db.ConnectionInspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangxj1977
 *
 */
public abstract class AbstractConnectionInspect implements ConnectionInspect {

	/**
	 * log handler
	 */
	Logger log = LoggerFactory.getLogger(this.getClass());

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

	/**
	 * @param autoCommit
	 * @see java.sql.Connection#setAutoCommit(boolean)
	 */
	public void setAutoCommit(boolean autoCommit) {
		try {
			connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

	/**
	 * @return
	 * @see java.sql.Connection#getAutoCommit()
	 */
	public boolean getAutoCommit() {
		try {
			return connection.getAutoCommit();
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

	/**
	 * @see java.sql.Connection#commit()
	 */
	public void commit() {
		try {
			connection.commit();
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

	/**
	 * @see java.sql.Connection#rollback()
	 */
	public void rollback() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

	/**
	 * @see java.sql.Connection#close()
	 */
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

}
