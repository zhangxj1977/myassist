/**
 * 
 */
package org.sjitech.myassist.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.sjitech.myassist.core.ApplicationException;
import org.sjitech.myassist.core.config.ConfigConnection;

/**
 * database driver inspect manager class. it can be get database meta info by
 * jdbc api or by database system tables/views
 * 
 * @author sji_zhang_x
 * 
 */
public class DriverInspectManager {

	/**
	 * get connection inspect instance by the configured name
	 * 
	 * @param type
	 * @param name
	 * @return
	 */
	public static ConnectionInspect getConnectionInspect(ConfigConnection config) {
		try {
			Class.forName(config.getDriverClass());

			Properties props = new Properties();
			if (config.getConnectProperties() != null) {
				props.putAll(config.getConnectProperties());
			}
			props.put("user", config.getUser());
			props.put("password", config.getPasswd());

			Connection conn = DriverManager.getConnection(config.getUrl(),
					props);

			switch (config.getDbType()) {
			case DB2:
			case Oracle:
			case Common:
				return new CommonConnectionInspect(conn);
			default:
				return new CommonConnectionInspect(conn);
			}
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}

}
