package com.webservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MockLogger {

	Logger log = LogManager.getLogger(MockLogger.class);
	
	public void LoggerTest(){
		log.info("---------I'm called--------");
	}
}
