package com.webservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.it.dao.JdbcDao;
import com.it.mybatis.MybatisDao;
import com.it.utils.GsonUtil;
import com.model.EMP;
import com.webservice.DefaultResponse;
import com.webservice.header.IEmployeeService;

import net.sf.json.JSONObject;

public class EmployeeService extends DefaultResponse implements IEmployeeService{

	@Autowired
	JdbcDao jdbcDao;

	@Autowired
	MybatisDao dao;
	
	@Override
	public Object search(String json) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from EMP";
		List<Map<String,Object>>result =jdbcDao.query(sql);	
	
		return responseSuccess(toJsonObject(result));		
	}

	@Override
	public Object insert(String json) throws Exception {
		if(StringUtils.isEmpty(json)){
			return responseFailed();
		}
		else{
			try{
				Object o =JSONObject.fromObject(json);
				Object jsonObject = GsonUtil.fromJson(json, EMP.class);
						
				String s ="aa";
			}
			catch(Exception e){			
				e.printStackTrace();
				return responseFailed();
			}
			
		}
		
		return responseSuccess(defaultResponse());
		
	}

	@Override
	public Object update(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object delete(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
