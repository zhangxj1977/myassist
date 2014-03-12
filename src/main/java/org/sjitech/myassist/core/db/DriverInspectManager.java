/**
 * 
 */
package org.sjitech.myassist.core.db;

import org.sjitech.myassist.core.config.ConfigConnection;

/**
 * database driver inspect manager class.
 * it can be get database meta info by jdbc api or 
 * by database system tables/views
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
		// TODO return real instance by config
		return null;
	}

}
