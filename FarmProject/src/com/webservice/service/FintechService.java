package com.webservice.service;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.it.dao.JdbcDao;
import com.it.mybatis.MybatisDao;
import com.webservice.header.IFintechService;

import net.sf.json.JSONObject;

public class FintechService implements IFintechService {

	@Autowired
	JdbcDao jdbcDao;

	@Autowired
	MybatisDao dao;

	@Override
	public Object getData() throws Exception {

		JSONObject jObject = new JSONObject();
		jObject.put("Title", "新加坡監理沙盒準則出爐，高規格要求原創點子才能申請");
		jObject.put("date", "2016-11-23");

		System.out.println("success to get Data");

		String sql = "select * from T_A_ORG";
		List<Map<String, Object>> results = (List<Map<String, Object>>) jdbcDao.query(sql);

		if (results != null) {
			System.out.println(results.get(0));
		} else {
			System.out.println("jdbc error");
		}

		String condition = "OFFICE008";
		List result = dao.execute("getCallDetails", condition);

		if (result != null) {
			System.out.println(result.get(0));
		} else {
			System.out.println("mybatis error");
		}

		String s = "aaa";

		return jObject.toString();

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

	@Override
	public Object getDataJson() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDataOption() throws Exception {
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

}
