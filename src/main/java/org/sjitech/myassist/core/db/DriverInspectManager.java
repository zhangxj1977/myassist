/**
 * 
 */
package org.sjitech.myassist.core.db;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.sjitech.myassist.core.ApplicationException;
import org.sjitech.myassist.core.db.config.ConfigConnection;
import org.sjitech.myassist.core.db.inspect.CommonConnectionInspect;
import org.sjitech.myassist.core.db.inspect.DB2ConnectionInspect;
import org.sjitech.myassist.core.db.inspect.OracleConnectionInspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * database driver inspect manager class. it can be get database meta info by
 * jdbc api or by database system tables/views
 * 
 * @author sji_zhang_x
 * 
 */
public class DriverInspectManager {

	/**
	 * log handler
	 */
	static Logger log = LoggerFactory.getLogger(DriverInspectManager.class);

	/**
	 * get connection inspect instance by the configured name
	 * 
	 * @param type
	 * @param name
	 * @return
	 */
	public static ConnectionInspect getConnectionInspect(ConfigConnection config) {
		if (log.isDebugEnabled()) {
			log.debug("connect to " + config.getDbType() + ". url=" + config.getUrl());
		}

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

			// set the client info
			String osUserName = System.getProperty("user.name");
			String clientHostName = InetAddress.getLocalHost().getHostName();
			conn.setClientInfo("ApplicationName", "myassist");
			conn.setClientInfo("ClientUser", osUserName);
			conn.setClientInfo("ClientHostname", clientHostName);

			if (log.isDebugEnabled()) {
				log.debug("ClientUser=" + osUserName);
				log.debug("ClientHostname=" + clientHostName);
			}

			switch (config.getDbType()) {
			case DB2:
				return new DB2ConnectionInspect(conn);
			case Oracle:
				return new OracleConnectionInspect(conn);
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
