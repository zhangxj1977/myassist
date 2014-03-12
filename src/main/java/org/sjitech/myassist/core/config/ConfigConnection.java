package org.sjitech.myassist.core.config;

import java.util.Properties;

/**
 * connection config class
 * 
 * @author sji_zhang_x
 *
 */
public class ConfigConnection {

	/**
	 * database type
	 */
	private DBType dbType = DBType.Common;

	/**
	 * connection name
	 */
	private String name = null;

	/**
	 * connect driver class name
	 */
	private String driverClass = null;

	/**
	 * connect user
	 */
	private String user = null;

	/**
	 * connect user password
	 */
	private String passwd = null;

	/**
	 * connect url
	 */
	private String url = null;
	
	/**
	 * connect properties
	 */
	private Properties connectProperties = null;

	/**
	 * @return dbType
	 */
	public DBType getDbType() {
		return dbType;
	}

	/**
	 * @param dbType �Z�b�g���� dbType
	 */
	public void setDbType(DBType dbType) {
		this.dbType = dbType;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name �Z�b�g���� name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return driverClass
	 */
	public String getDriverClass() {
		return driverClass;
	}

	/**
	 * @param driverClass �Z�b�g���� driverClass
	 */
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	/**
	 * @return user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user �Z�b�g���� user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd �Z�b�g���� passwd
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url �Z�b�g���� url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return connectProperties
	 */
	public Properties getConnectProperties() {
		return connectProperties;
	}

	/**
	 * @param connectProperties �Z�b�g���� connectProperties
	 */
	public void setConnectProperties(Properties connectProperties) {
		this.connectProperties = connectProperties;
	}
	
	
}
