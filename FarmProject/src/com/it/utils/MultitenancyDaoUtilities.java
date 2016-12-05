package com.it.utils;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultitenancyDaoUtilities {
	  private static Logger log = LogManager.getLogger(MultitenancyDaoUtilities.class);
	  public static Boolean ISTENANCY = Boolean.valueOf(true);
	  private final String where = "where ";
	  private final String where1 = " where 1 = 1 ";
	  private final String space = " ";
	  private final String select = "select ";
	  private final String update = "update ";
	  private final String insert = "insert ";
	  private final String delete = "delete ";
	  private final String into = "into ";
	  private final String and = "and ";
	  private final String pHqlManage = "multiTenancy";
	  private final String set = "set ";
	  private final String from = "from ";
	  private final String join = "join ";
	  private final String inner = "inner ";
	  private final String left = "left ";
	  private final String on = "on";
	  private final String as = " as ";
	  private final String order = " order ";
	  private final String group = " group ";
	  private final String by = "by";
	  public static final int DOINSERT = 1;
	  public static final int DOUPDATE = 2;
	  public static final int DOSELECT = 3;
	  public static final int DODELETE = 4;
	  private static String[] UPDATEFIELD = { "modiby", "modidate", "flag" };
	  private static String[] UPDATEWHERE = { "tenantgroup", "company" };
	  private static String[] INSERTFIELD = { "tenantgroup", "company", "creator", "createdate", "flag" };
	  private static String[] INSERTWHERE = new String[0];
	  private static String[] SELECTFIELD = new String[0];
	  private static String[] SELECTWHERE = { "tenantgroup", "company" };
	  private static String[] DELETEFIELD = new String[0];
	  private static String[] DELETEWHERE = { "tenantgroup", "company" };
	  private static final String FLAG = "flag";
//	  private static String MUTLITENANCYCLASS = Tenancy.class.getName();
	  private static final boolean SHOWSQL = true;
//	  private static Map<String, PersistentMapperClass> gdaoMap;
	  public static MultitenancyDaoUtilities multitenancyUtility = null;
	  private static ResourceBundle bundle;
	  private static String initDB = "";
	  private static final String FLAGSTR = "__";
	  private static final String SSTR = "/*";
	  private static final String ESTR = "*/";
	  private static final int HQL = 99561;
	  private static final int SQL = 89102;
	  private static final String PSSTR = "{";
	  private static final String PESTR = "}";
	
	
	public static MultitenancyDaoUtilities getInstance()
	  {
	    if (multitenancyUtility == null) {
	      synchronized (MultitenancyDaoUtilities.class)
	      {
	        if (multitenancyUtility == null)
	        {
	          multitenancyUtility = new MultitenancyDaoUtilities();
//	          gdaoMap = HibernateConfigUtil.configure();
	        }
	        try
	        {
	          bundle = ResourceBundle.getBundle("system");
	        }
	        catch (Exception localException)
	        {
	          log.error("No system.properties find in src");
	        }
	        if ((bundle != null) && (bundle.containsKey("DB"))) {
	          initDB = bundle.getString("DB");
	        }
	      }
	    }
	    return multitenancyUtility;
	  }
}
