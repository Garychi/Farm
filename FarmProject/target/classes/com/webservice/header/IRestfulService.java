package com.webservice.header;

import java.util.Map;

public interface IRestfulService {
	
	public void invoke(String srvName,String method) throws Exception;
	
	public void invoke(String srvName,String method,Map<String,Object> paramMap) throws Exception;
}
