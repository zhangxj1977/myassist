package org.sjitech.myassist.core.db.inspect;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sjitech.myassist.core.ApplicationException;
import org.sjitech.myassist.core.db.object.SchemaObject;
import org.sjitech.myassist.core.db.object.TableObject;


/**
 * @author sji_zhang_x
 *
 */
public class CommonConnectionInspect extends AbstractConnectionInspect {

	/**
	 * @param conn
	 */
	public CommonConnectionInspect(Connection conn) {
		super(conn);
	}

	/**
	 * get database support infomation
	 * @return
	 */
	public Map<String, String> getDataBaseInfo() {
		Map<String, String> infos = new HashMap<String, String>();

		try {
			DatabaseMetaData dbMetaData = connection.getMetaData();

			Method[] allMethods = dbMetaData.getClass().getMethods();
			for (Method method : allMethods) {
				Class<?> returnType = method.getReturnType();
				Class<?>[] paramType = method.getParameterTypes();

				if ((returnType.isPrimitive() || returnType == String.class)
						&& returnType != void.class
						&& paramType.length == 0) {
					if ("hashCode".equals(method.getName())
							|| "toString".equals(method.getName())) {
						continue;
					}

					String value = null;
					try {
						value = String.valueOf(method.invoke(dbMetaData));
					} catch (Exception e) {
						value = "-";
					}
					infos.put(method.getName(), value);
				}
			}

			return infos;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

    /**
     * @see java.sql.DatabaseMetaData#getSchemas()
     */
    public List<SchemaObject> getSchemas() {

		try {
			DatabaseMetaData dbMetaData = connection.getMetaData();
			ResultSet rs = dbMetaData.getSchemas();

			List<SchemaObject> schemaList = new ArrayList<SchemaObject>();
			while (rs.next()) {
				SchemaObject schemaData = new SchemaObject();

				schemaData.setCatalog(rs.getString("TABLE_CATALOG"));
				schemaData.setSchema(rs.getString("TABLE_SCHEM"));

				schemaList.add(schemaData);
			}
			rs.close();

			return schemaList;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
    }

    /**
     * @see java.sql.DatabaseMetaData#getTableTypes()
     */
    public List<String> getTableTypes() {

		try {
			DatabaseMetaData dbMetaData = connection.getMetaData();
			ResultSet rs = dbMetaData.getTableTypes();

			List<String> typeList = new ArrayList<String>();
			while (rs.next()) {
				typeList.add(rs.getString("TABLE_TYPE"));
			}
			rs.close();

			return typeList;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
    }

	/* (”ñ Javadoc)
	 * @see org.sjitech.myassist.core.db.ConnectionInspect#getTables(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Override
	public List<TableObject> getTables(String catalog, String schemaPattern,
			String tableNamePattern, String[] types) {

		try {
			DatabaseMetaData dbMetaData = connection.getMetaData();
			ResultSet rs = dbMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);

			List<TableObject> tableList = new ArrayList<TableObject>();
			while (rs.next()) {
				TableObject tableData = new TableObject();

			    tableData.setCatalog(rs.getString("TABLE_CAT"));
			    tableData.setSchema(rs.getString("TABLE_SCHEM"));
				tableData.setTableName(rs.getString("TABLE_NAME"));
				tableData.setTableType(rs.getString("TABLE_TYPE"));
			    tableData.setRemarks(rs.getString("REMARKS"));

				tableList.add(tableData);
			}
			rs.close();

			return tableList;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		}
	}

}
