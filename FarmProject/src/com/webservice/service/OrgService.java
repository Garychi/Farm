package com.webservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.it.dao.JdbcDao;
import com.it.mybatis.MybatisDao;
import com.webservice.DefaultResponse;
import com.webservice.header.IOrgService;

public class OrgService extends DefaultResponse implements IOrgService{

	@Autowired
	JdbcDao jdbcDao;
	
	@Autowired
	MybatisDao mybatisDao;
	
	@Override
	public Object search(String json) throws Exception {
		String sql = "select * from T_A_ORG ";
		List<Map<String,Object>>result =jdbcDao.query(sql);	
	
		return responseSuccess(toJsonObject(result));		
	}

	@Override
	public Object insert(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
