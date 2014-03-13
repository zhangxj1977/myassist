package org.sjitech.myassist.test;

import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sjitech.myassist.core.db.ConnectionInspect;
import org.sjitech.myassist.core.db.DriverInspectManager;
import org.sjitech.myassist.core.db.config.ConfigConnection;
import org.sjitech.myassist.core.db.config.DBType;
import org.sjitech.myassist.core.db.object.SchemaObject;
import org.sjitech.myassist.core.db.object.TableObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDriver {

	static Logger log = LoggerFactory.getLogger(TestDriver.class);
	
	static ConnectionInspect conn = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ConfigConnection config = new ConfigConnection();
		
		config.setName("migradb");
		config.setUser("claim");
		config.setPasswd("claimdb2");
		config.setDbType(DBType.DB2);
		config.setDriverClass("com.ibm.db2.jcc.DB2Driver");
		config.setUrl("jdbc:db2://10.167.48.252:50000/MIGRADB:currentSchema=CLAIM;");
		
		conn = DriverInspectManager.getConnectionInspect(config);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if (conn != null) {
			conn.close();
		}
	}

	public void testGetTables() {

		List<SchemaObject> scheList = conn.getSchemas();
		List<String> typeList = conn.getTableTypes();
		for (SchemaObject schema : scheList) {
			for (String type : typeList) {
				List<TableObject> tblList = conn.getTables(
						schema.getCatalog(),
						schema.getSchema(),
						null,
						new String[]{type});
				
				for (TableObject tableObject : tblList) {
					log.debug(tableObject.toString());
				}
			}
		}
	
	}

	@Test
	public void testGetDBInfo() {

		Map<String, String> infos = conn.getDataBaseInfo();
		log.debug(infos.toString());
	}
}
