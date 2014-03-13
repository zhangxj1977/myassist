/**
 * 
 */
package org.sjitech.myassist.core.db;

import java.util.List;
import java.util.Map;

import org.sjitech.myassist.core.db.object.SchemaObject;
import org.sjitech.myassist.core.db.object.TableObject;

/**
 * 
 * @author sji_zhang_x
 *
 */
public interface ConnectionInspect {

	/**
	 * get database infomation
	 * 
	 * @return
	 */
	Map<String, String> getDataBaseInfo();
	
    /**
     * @see java.sql.DatabaseMetaData#getSchemas()
     */
    List<SchemaObject> getSchemas();

    /**
     * @see java.sql.DatabaseMetaData#getTableTypes()
     */
    List<String> getTableTypes();

	/**
	 * get all tables bye catalog/schema/name.etc
	 * 
	 * @param catalog
	 * @param schemaPattern
	 * @param tableNamePattern
	 * @param types
	 * @return
	 * @see java.sql.DatabaseMetaData#getTables(String, String, String, String[])
	 */
	List<TableObject> getTables(String catalog, String schemaPattern,
			String tableNamePattern, String types[]);

	/**
	 * @param autoCommit
	 * @see java.sql.Connection#setAutoCommit(boolean)
	 */
	public void setAutoCommit(boolean autoCommit);

	/**
	 * @return
	 * @see java.sql.Connection#getAutoCommit()
	 */
	public boolean getAutoCommit();

	/**
	 * @see java.sql.Connection#commit()
	 */
	public void commit();

	/**
	 * @see java.sql.Connection#rollback()
	 */
	public void rollback();

	/**
	 * @see java.sql.Connection#close()
	 */
	public void close();

}
