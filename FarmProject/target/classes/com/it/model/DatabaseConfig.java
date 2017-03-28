package com.it.model;

import java.io.Serializable;

public class DatabaseConfig implements Serializable {
	private static final long serialVersionUID = -7015315695427137849L;

	private String databaseID;
	private String driverClassName;
	private String userName;
	private String userPassword;
	private String connectionURL;
	private Integer initPoolsize;
	private Integer maxActiveConn;
	private Integer maxIdleConn;
	private Integer minIdleConn;
	private Integer maxWaittime;
	private String hibernateDialect;
	private String defaultSchema;
	private String defaultDatabase;
	private String databaseType;
	private String transactionLevel;
	private boolean testOnBorrow;
	private String validationQuery;
	private Long minEvictableIdleTimeMillis;
	private Long timeBetweenEvictionRunsMillis;
	private boolean testWhileIdle;
	private boolean testOnReturn;
	private boolean removeAbandoned;
	private Integer removeAbandonedTimeout;
	private boolean logAbandoned;

	public DatabaseConfig() {

	}

	public String getDatabaseID() {
		return databaseID;
	}

	public void setDatabaseID(String databaseID) {
		this.databaseID = databaseID;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getConnectionURL() {
		return connectionURL;
	}

	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}

	public Integer getInitPoolsize() {
		return initPoolsize;
	}

	public void setInitPoolsize(Integer initPoolsize) {
		this.initPoolsize = initPoolsize;
	}

	public Integer getMaxActiveConn() {
		return maxActiveConn;
	}

	public void setMaxActiveConn(Integer maxActiveConn) {
		this.maxActiveConn = maxActiveConn;
	}

	public Integer getMaxIdleConn() {
		return maxIdleConn;
	}

	public void setMaxIdleConn(Integer maxIdleConn) {
		this.maxIdleConn = maxIdleConn;
	}

	public Integer getMinIdleConn() {
		return minIdleConn;
	}

	public void setMinIdleConn(Integer minIdleConn) {
		this.minIdleConn = minIdleConn;
	}

	public Integer getMaxWaittime() {
		return maxWaittime;
	}

	public void setMaxWaittime(Integer maxWaittime) {
		this.maxWaittime = maxWaittime;
	}

	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getDefaultSchema() {
		return defaultSchema;
	}

	public void setDefaultSchema(String defaultSchema) {
		this.defaultSchema = defaultSchema;
	}

	public String getDefaultDatabase() {
		return defaultDatabase;
	}

	public void setDefaultDatabase(String defaultDatabase) {
		this.defaultDatabase = defaultDatabase;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	public String getTransactionLevel() {
		return transactionLevel;
	}

	public void setTransactionLevel(String transactionLevel) {
		this.transactionLevel = transactionLevel;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public Long getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(Long minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public Long getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(Long timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public boolean isRemoveAbandoned() {
		return removeAbandoned;
	}

	public void setRemoveAbandoned(boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}

	public Integer getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}

	public void setRemoveAbandonedTimeout(Integer removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}

	public boolean isLogAbandoned() {
		return logAbandoned;
	}

	public void setLogAbandoned(boolean logAbandoned) {
		this.logAbandoned = logAbandoned;
	}
}
