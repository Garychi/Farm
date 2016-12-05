package com.webservice.service;

import java.util.Map;

import com.webservice.header.IRestfulService;

public class RestfulService implements IRestfulService{
	
	private String srvName;
	private String method;
	
	@Override
	public void invoke(String srvName, String method) throws Exception {
		
	}

	@Override
	public void invoke(String srvName, String method, Map<String, Object> paramMap) throws Exception {
		
	}

}
