package com.it.init;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.it.model.DatabaseConfig;
import com.it.utils.MultitenancyDaoUtilities;

public class DataSourceInit {
	private static DataSourceInit instance;
	private static Logger log = LogManager.getLogger(DataSourceInit.class);
	private static DataSource ds;
	private static final String SQL = " select * from DatabaseConfig where 1 = 1 ";
	static Map<String, Map<String, String>> hibernateDialectMap = new HashMap();
	public static Map<String, DatabaseConfig> dcMap = new HashMap();
	public static String defaultSource = "";
	private static MultitenancyDaoUtilities multitenancyUtils = MultitenancyDaoUtilities.getInstance();
	public static final ResourceBundle bundle = ResourceBundle.getBundle("system");

	private DataSourceInit() {
		try {
			if (ds == null) {
				InitialContext localInitialContext = new InitialContext();
				ds = (DataSource) localInitialContext.lookup("java:comp/env/jdbc/initDB");
				log.info(" DataSource init Complete ");
			}
		}
		catch (NamingException localNamingException) {
			localNamingException.printStackTrace();
		}
	}

	public static DataSourceInit getInstance() {
		if (instance == null) {
			synchronized (DataSourceInit.class) {
				if (instance == null) {
					instance = new DataSourceInit();
				}
			}
		}
		return instance;
	}

	public Map<String, Object> getDigiwinDataSource() {
		HashMap localHashMap = new HashMap();
		Connection localConnection = null;
		try {
			if (ds != null) {
				localConnection = ds.getConnection();
				PreparedStatement localPreparedStatement = localConnection.prepareStatement(" select * from DatabaseConfig where 1 = 1 ");
				ResultSet localResultSet = localPreparedStatement.executeQuery();
				BasicDataSource localBasicDataSource = null;
				DatabaseConfig localDatabaseConfig = null;
				while (localResultSet.next()) {
					localBasicDataSource = new BasicDataSource();
					String str1 = localResultSet.getString("DatabaseID");
					String str2 = localResultSet.getString("DefaultDatabase");
					if ((str2 != null) && ("Y".equalsIgnoreCase(str2))) {
						defaultSource = str1;
					}
					setDataSource(localBasicDataSource , localResultSet);
					localDatabaseConfig = new DatabaseConfig();
					localDatabaseConfig.setDatabaseID(str1);
					localDatabaseConfig.setDefaultDatabase(str2);
					localDatabaseConfig.setConnectionURL(localResultSet.getString("ConnectionURL"));
					localDatabaseConfig.setDatabaseType(localResultSet.getString("DatabaseType"));
					localDatabaseConfig.setDefaultDatabase(localResultSet.getString("DefaultDatabase"));
					localDatabaseConfig.setDefaultSchema(localResultSet.getString("DefaultSchema"));
					localDatabaseConfig.setDriverClassName(localResultSet.getString("DriverClassName"));
					localDatabaseConfig.setHibernateDialect(localResultSet.getString("HibernateDialect"));
					localDatabaseConfig.setInitPoolsize(Integer.valueOf(localResultSet.getInt("InitPoolsize")));
					localDatabaseConfig.setMaxActiveConn(Integer.valueOf(localResultSet.getInt("MaxActiveConn")));
					localDatabaseConfig.setMaxIdleConn(Integer.valueOf(localResultSet.getInt("MaxIdleConn")));
					localDatabaseConfig.setMaxWaittime(Integer.valueOf(localResultSet.getInt("MaxWaittime")));
					localDatabaseConfig.setTransactionLevel(localResultSet.getString("TransactionLevel"));
					localDatabaseConfig.setTestOnBorrow(localBasicDataSource.getTestOnBorrow());
					localDatabaseConfig.setValidationQuery(localBasicDataSource.getValidationQuery());
					localDatabaseConfig.setTestOnReturn(localBasicDataSource.getTestOnReturn());
					localDatabaseConfig.setTestWhileIdle(localBasicDataSource.getTestWhileIdle());
					localDatabaseConfig.setLogAbandoned(localBasicDataSource.getLogAbandoned());
					localDatabaseConfig.setTimeBetweenEvictionRunsMillis(Long.valueOf(localBasicDataSource.getTimeBetweenEvictionRunsMillis()));
					localDatabaseConfig.setRemoveAbandonedTimeout(Integer.valueOf(localBasicDataSource.getRemoveAbandonedTimeout()));
					localDatabaseConfig.setRemoveAbandoned(localBasicDataSource.getRemoveAbandoned());
					localDatabaseConfig.setMinEvictableIdleTimeMillis(Long.valueOf(localBasicDataSource.getMinEvictableIdleTimeMillis()));
					String str3 = localResultSet.getString("UserName");
					localDatabaseConfig.setUserName(str3);
					String str4 = localResultSet.getString("UserPassword");
					localDatabaseConfig.setUserPassword(str4);
					dcMap.put(str1 , localDatabaseConfig);
					localHashMap.put(str1 , localBasicDataSource);
				}
				localPreparedStatement.clearBatch();
				localPreparedStatement.close();
				localResultSet.close();
				localConnection.close();
				log.info("DataSource Create Complete");
			}
			else {
				log.info("DataSource is null");
			}
		}
		catch (SQLException localSQLException1) {
			localSQLException1.printStackTrace();
			log.error(localSQLException1.getMessage());
			if (localConnection != null) {
				try {
					localConnection.close();
				}
				catch (SQLException localSQLException2) {
					localSQLException2.printStackTrace();
					log.error(localSQLException2.getMessage());
				}
			}
		}
		catch (Exception localException) {
			log.error(localException.getMessage());
			if (localConnection != null) {
				try {
					localConnection.close();
				}
				catch (SQLException localSQLException3) {
					localSQLException3.printStackTrace();
					log.error(localSQLException3.getMessage());
				}
			}
		}
		log.info("DataSource Info : " + localHashMap.toString());
		return localHashMap;
	}

	public Object getNewDataSource(String paramString)
			throws Exception {
		BasicDataSource localBasicDataSource = null;
		Connection localConnection = null;
		try {
			if (ds != null) {
				localConnection = ds.getConnection();
				PreparedStatement localPreparedStatement = localConnection.prepareStatement(" select * from DatabaseConfig where 1 = 1 ");
				ResultSet localResultSet = localPreparedStatement.executeQuery();
				while (localResultSet.next()) {
					localBasicDataSource = new BasicDataSource();
					setDataSource(localBasicDataSource , localResultSet);
				}
				localPreparedStatement.clearBatch();
				localPreparedStatement.close();
				localResultSet.close();
				localConnection.close();
				log.info("DataSource Create Complete");
			}
		}
		catch (SQLException localSQLException) {
			log.error(localSQLException.getMessage());
			if (localConnection != null) {
				localConnection.close();
			}
			throw new SQLException(localSQLException);
		}
		catch (Exception localException) {
			log.error(localException.getMessage());
			if (localConnection != null) {
				localConnection.close();
			}
			throw new Exception(localException);
		}
		return localBasicDataSource;
	}

	private void setDataSource(BasicDataSource paramBasicDataSource, ResultSet paramResultSet)
			throws SQLException {
		ResultSetMetaData localResultSetMetaData = paramResultSet.getMetaData();
		int i = localResultSetMetaData.getColumnCount();
		int j = 0;
		int k = 0;
		int m = 0;
		int n = 0;
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		int i5 = 0;
		for (int i6 = 1; i6 <= i; i6++) {
			String str2 = localResultSetMetaData.getColumnName(i6);
			if ("TestOnBorrow".equalsIgnoreCase(str2)) {
				j = 1;
			}
			else if ("ValidationQuery".equalsIgnoreCase(str2)) {
				k = 1;
			}
			else if ("MinEvictableIdleTimeMillis".equalsIgnoreCase(str2)) {
				m = 1;
			}
			else if ("TimeBetweenEvictionRunsMillis".equalsIgnoreCase(str2)) {
				n = 1;
			}
			else if ("TestWhileIdle".equalsIgnoreCase(str2)) {
				i1 = 1;
			}
			else if ("TestOnReturn".equalsIgnoreCase(str2)) {
				i2 = 1;
			}
			else if ("RemoveAbandoned".equalsIgnoreCase(str2)) {
				i3 = 1;
			}
			else if ("RemoveAbandonedTimeout".equalsIgnoreCase(str2)) {
				i4 = 1;
			}
			else if ("LogAbandoned".equalsIgnoreCase(str2)) {
				i5 = 1;
			}
		}
		String str1 = paramResultSet.getString("DriverClassName");
		String str2 = paramResultSet.getString("UserName");
		String str3 = paramResultSet.getString("UserPassword");
		String str4 = paramResultSet.getString("ConnectionURL");
		int i7 = paramResultSet.getInt("InitPoolsize");
		int i8 = paramResultSet.getInt("MaxActiveConn");
		int i9 = paramResultSet.getInt("MaxIdleConn");
		int i10 = paramResultSet.getInt("MinIdleConn");
		int i11 = paramResultSet.getInt("MaxWaittime");
		String str5 = paramResultSet.getString("HibernateDialect");
		String str6 = paramResultSet.getString("DefaultSchema");
		String str7 = paramResultSet.getString("DatabaseID");
		String str8 = paramResultSet.getString("TransactionLevel");
		String str9 = j != 0 ? paramResultSet.getString("TestOnBorrow") : "false";
		String str10 = k != 0 ? paramResultSet.getString("ValidationQuery") : "";
		int i12 = m != 0 ? paramResultSet.getInt("MinEvictableIdleTimeMillis") : 0;
		int i13 = n != 0 ? paramResultSet.getInt("TimeBetweenEvictionRunsMillis") : 0;
		String str11 = i1 != 0 ? paramResultSet.getString("TestWhileIdle") : "false";
		String str12 = i2 != 0 ? paramResultSet.getString("TestWhileIdle") : "false";
		String str13 = i3 != 0 ? paramResultSet.getString("RemoveAbandoned") : "false";
		int i14 = i4 != 0 ? paramResultSet.getInt("RemoveAbandonedTimeout") : 0;
		String str14 = i5 != 0 ? paramResultSet.getString("LogAbandoned") : "false";
		paramBasicDataSource.setUrl(str4);
		paramBasicDataSource.setDriverClassName(str1);
		paramBasicDataSource.setUsername(str2);
		paramBasicDataSource.setPassword(str3);
		paramBasicDataSource.setInitialSize(i7);
		paramBasicDataSource.setMaxActive(i8);
		paramBasicDataSource.setMaxIdle(i9);
		paramBasicDataSource.setMinIdle(i10);
		paramBasicDataSource.setMaxWait(i11);
		if (i12 > 0) {
			paramBasicDataSource.setMinEvictableIdleTimeMillis(i12);
		}
		if (i13 > 0) {
			paramBasicDataSource.setTimeBetweenEvictionRunsMillis(i13);
		}
		if ("true".equalsIgnoreCase(str11)) {
			paramBasicDataSource.setTestWhileIdle(true);
		}
		if ("true".equalsIgnoreCase(str12)) {
			paramBasicDataSource.setTestOnReturn(true);
		}
		if (("true".equals(str13)) && (i14 > 0)) {
			paramBasicDataSource.setRemoveAbandonedTimeout(i14);
		}
		if ("true".equalsIgnoreCase(str14)) {
			paramBasicDataSource.setLogAbandoned(true);
		}
		if ("true".equalsIgnoreCase(str9)) {
			paramBasicDataSource.setTestOnBorrow(true);
		}
		if (StringUtils.isNotBlank(str10)) {
			paramBasicDataSource.setValidationQuery(str10);
		}
		if (StringUtils.isNotBlank(str8)) {
			if ("TRANSACTION_READ_COMMITTED".equalsIgnoreCase(str8)) {
				paramBasicDataSource.setDefaultTransactionIsolation(2);
			}
			else if ("TRANSACTION_READ_UNCOMMITTED".equalsIgnoreCase(str8)) {
				paramBasicDataSource.setDefaultTransactionIsolation(1);
			}
			else if ("TRANSACTION_REPEATABLE_READ".equalsIgnoreCase(str8)) {
				paramBasicDataSource.setDefaultTransactionIsolation(4);
			}
			else if ("TRANSACTION_SERIALIZABLE".equalsIgnoreCase(str8)) {
				paramBasicDataSource.setDefaultTransactionIsolation(8);
			}
			else if ("TRANSACTION_NONE".equalsIgnoreCase(str8)) {
				paramBasicDataSource.setDefaultTransactionIsolation(0);
			}
		}
		HashMap localHashMap = new HashMap();
		localHashMap.put("hibernateDialect" , str5);
		localHashMap.put("defaultSchema" , str6);
		if (!hibernateDialectMap.containsKey(str7)) {
			hibernateDialectMap.put(str7 , localHashMap);
		}
	}
}
