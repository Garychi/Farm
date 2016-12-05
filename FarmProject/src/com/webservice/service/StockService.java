package com.webservice.service;

import javax.ws.rs.core.Response;

import com.webservice.header.IStockService;

import net.sf.json.JSONObject;

public class StockService implements IStockService{

	@Override
	public Object getData() throws Exception {
		JSONObject jObject = new JSONObject();
		jObject.put("Title" ,"新加坡監理沙盒準則出爐，高規格要求原創點子才能申請");
		jObject.put("date" , "2016-11-23");
		
		System.out.println("success to  get Stock Data");
		
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(jObject.toString())
	            .build();
	}

	@Override
	public Object getDataJson() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
