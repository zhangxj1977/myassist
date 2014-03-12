/**
 * 
 */
package org.sjitech.myassist.core.db;

import java.util.List;

/**
 * 
 * @author sji_zhang_x
 *
 */
public interface ConnectionInspect {

	/**
	 * get all tables bye catalog/schema/name.etc
	 * 
	 * @see java.sql.DatabaseMetaData.getTables
	 * @param catalog
	 * @param schemaPattern
	 * @param tableNamePattern
	 * @param types
	 * @return
	 */
	List<TableObject> getTables(String catalog, String schemaPattern,
			String tableNamePattern, String types[]);

}
