package com.webservice;

import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import com.it.utils.GsonUtil;

import net.sf.json.JSONObject;

public abstract class DefaultResponse {
		
	protected Response responseSuccess(Object result){
		// 設定HTTP Status以及Response Body
		StatusType status=result !=null ? Status.OK : Status.NO_CONTENT;
		
		ResponseBuilder builder = Response.status(status).entity(result);
		builder.header("Content-Type", "application/json;charset=UTF-8");
		
		// 生成Response
		Response response = builder.build();

		// 回傳Response
		return response;	
	}
	
	protected Response responseFailed(){
		JSONObject json = new JSONObject();
		json.put("data", "request json is empty or null");
		
		ResponseBuilder builder = Response.status(Status.FORBIDDEN).entity(GsonUtil.toJson(json));
		builder.header("Content-Type", "application/json;charset=UTF-8");
		
		// 生成Response
		Response response = builder.build();

		// 回傳Response
		return response;	
	}
	
	
	protected Object defaultResponse() {
		JSONObject json= new JSONObject();		
		json.put("status", "OK");
		json.put("data", "request is processed");
		json.put("date", new Date());
		return toJsonObject(json);

	}
	
	protected Object toJsonObject(Object data) {
		return data == null ? GsonUtil.toJson(new HashMap<String, Object>().put("data", "no data")) : GsonUtil.toJson(data);
	}

}
