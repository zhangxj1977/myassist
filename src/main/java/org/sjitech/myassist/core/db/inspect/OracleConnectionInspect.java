package org.sjitech.myassist.core.db.inspect;

import java.sql.Connection;

/**
 * for oracle database
 * 
 * @author sji_zhang_x
 *
 */
public class OracleConnectionInspect extends CommonConnectionInspect {

	public OracleConnectionInspect(Connection conn) {
		super(conn);
	}

}
