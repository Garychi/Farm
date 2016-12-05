package com.it.utils;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtil {
	private static Logger logger = LogManager.getLogger(ConnectionUtil.class);

	/**
	 * 取得靜態文件設定檔的方法 1.ResourceBundle 2.Properties 他會取在classPath下的文件
	 */
	public void getStaticConfig() {
//		ResourceBundle bundle = ResourceBundle.getBundle("system");
//		String dataBase = bundle.getString("DATABASE");

		Properties props = new Properties();
		try {	
			props.load(getClass().getResourceAsStream("/system.properties"));
			Object configs = props.getProperty("DATABASE");
		}
		catch (Exception e) {
			logger.error("err");
		}
	}

}
