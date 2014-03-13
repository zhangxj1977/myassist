package org.sjitech.myassist.core.db.object;

/**
 * 
 * Each table description has the following columns:
 *  <OL>
 *	<LI>
 *  <LI><B>TYPE_CAT</B> String => the types catalog (may be <code>null</code>)
 *  <LI><B>TYPE_SCHEM</B> String => the types schema (may be <code>null</code>)	
 *  </OL>
 *
 * @author sji_zhang_x
 *
 */
public class SchemaObject {

	/**
	 * TABLE_CAT
	 */
	private String catalog = null;
	
	/**
	 * TABLE_SCHEM
	 */
	private String schema = null;


	/**
	 * @return catalog
	 */
	public String getCatalog() {
		return catalog;
	}


	/**
	 * @param catalog セットする catalog
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}


	/**
	 * @return schema
	 */
	public String getSchema() {
		return schema;
	}


	/**
	 * @param schema セットする schema
	 */
	public void setSchema(String schema) {
		this.schema = schema;
	}


	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TableObject [tableCat=" + catalog + ", tableSchem="
				+ schema + "]";
	}

}