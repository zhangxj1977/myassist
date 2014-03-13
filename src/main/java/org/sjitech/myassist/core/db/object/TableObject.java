package org.sjitech.myassist.core.db.object;

/**
 * 
 * Each table description has the following columns:
 *  <OL>
 *	<LI><B>TABLE_CAT</B> String => table catalog (may be <code>null</code>)
 *	<LI><B>TABLE_SCHEM</B> String => table schema (may be <code>null</code>)
 *	<LI><B>TABLE_NAME</B> String => table name
 *	<LI><B>TABLE_TYPE</B> String => table type.  Typical types are "TABLE",
 *			"VIEW",	"SYSTEM TABLE", "GLOBAL TEMPORARY", 
 *			"LOCAL TEMPORARY", "ALIAS", "SYNONYM".
 *	<LI><B>REMARKS</B> String => explanatory comment on the table
 *  <LI><B>TYPE_CAT</B> String => the types catalog (may be <code>null</code>)
 *  <LI><B>TYPE_SCHEM</B> String => the types schema (may be <code>null</code>)
 *  <LI><B>TYPE_NAME</B> String => type name (may be <code>null</code>)
 *  <LI><B>SELF_REFERENCING_COL_NAME</B> String => name of the designated 
 *                  "identifier" column of a typed table (may be <code>null</code>)
 *	<LI><B>REF_GENERATION</B> String => specifies how values in 
 *                  SELF_REFERENCING_COL_NAME are created. Values are
 *                  "SYSTEM", "USER", "DERIVED". (may be <code>null</code>)	
 *  </OL>
 *
 * @author sji_zhang_x
 *
 */
public class TableObject extends SchemaObject {

	/**
	 * TABLE_NAME
	 */
	private String tableName = null;

    /**
	 * TABLE_TYPE
	 */
	private String tableType = null;

	/**
	 * REMARKS
	 */
	private String remarks = null;


	/**
	 * @return tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName セットする tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return tableType
	 */
	public String getTableType() {
		return tableType;
	}

	/**
	 * @param tableType セットする tableType
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	/**
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks セットする remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TableObject [catalog=" + getCatalog() + ", schema="
				+ getSchema() + ", tableName=" + tableName + ", tableType="
				+ tableType + ", remarks=" + remarks + "]";
	}

}