package com.it.iservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface IWebService {
	public String getResponse(String param);
	public String getFarmInfo(List paramList);
	public String sayHello(@WebParam(name="text") String text);
}
