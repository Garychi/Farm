package com.webservice.service;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.it.dao.JdbcDao;
import com.it.mybatis.MybatisDao;
import com.webservice.DefaultResponse;
import com.webservice.header.IFintechService;

import net.sf.json.JSONObject;

public class FintechService extends DefaultResponse implements IFintechService {

	@Autowired
	JdbcDao jdbcDao;

	@Autowired
	MybatisDao dao;

	@Override
	public Object getData(String json) throws Exception {
		
		Object result =defaultResponse();
		
		// 設定HTTP Status以及Response Body
		ResponseBuilder builder = Response.status(Status.OK).entity(result);
		builder.header("Content-Type", "application/json;charset=UTF-8");
		
		// 生成Response
		Response response = builder.build();
	
		// 回傳Response
		return response;		
	}



	@Override
	public Object getDataJson(String json) throws Exception {
		// TODO Auto-generated method stub
		String s = "Aaa";
		return null;
	}

	@Override
	public Object getDataOption(Map<String, Object> map, String json) throws Exception {
		JSONObject jObject = new JSONObject();
		jObject.put("Title", "新加坡監理沙盒準則出爐，高規格要求原創點子才能申請");
		jObject.put("date", "2016-11-30");

		System.out.println("success to get Data");

		return Response.ok(jObject.toString(), MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "content-Type, authorization")
				// .header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST").header("Access-Control-Max-Age", "86400")
				.entity(jObject.toString()).build();
	}
	
	
	
	
	private Object getJDBCResult(String sql) {
		sql = "select * from EMP";
		List<Map<String, Object>> results = (List<Map<String, Object>>) jdbcDao.query(sql);
		return toJsonObject(results);
	}

	private Object getMybatisResult(String condition) throws Exception {
		List MyBaticresult = dao.execute("getCallDetails", condition);
		return toJsonObject(MyBaticresult);
	}
	
	private void crossDomainSetting(){
		// return Response
		// .ok(jObject.toString() , MediaType.APPLICATION_JSON)
		// .header("Access-Control-Allow-Origin" , "*")
		// .header("Access-Control-Allow-Headers" ,
		// "Content-Type,Authorization")
		//// .header("Access-Control-Allow-Credentials", "false")
		// .header("Access-Control-Allow-Methods" , "GET, POST,OPTIONS")
		// // .header("Access-Control-Max-Age" , "86400")
		// .entity(jObject.toString())
		// .build();
	}

}
