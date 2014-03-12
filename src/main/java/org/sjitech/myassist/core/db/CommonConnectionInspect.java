package org.sjitech.myassist.core.db;

import java.sql.Connection;
import java.util.List;

public class CommonConnectionInspect extends AbstractConnectionInspect {

	/**
	 * @param conn
	 */
	public CommonConnectionInspect(Connection conn) {
		super(conn);
	}

	@Override
	public List<TableObject> getTables(String catalog, String schemaPattern,
			String tableNamePattern, String[] types) {
		return null;
	}

}
