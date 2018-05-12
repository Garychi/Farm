package com.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.it.dao.JdbcDao;
import com.it.utils.GsonUtil;
import com.model.EMP;
import com.webservice.DefaultResponse;
import com.webservice.header.IEmployeeService;

public class EmployeeService extends DefaultResponse implements IEmployeeService {

	@Autowired
	JdbcDao jdbcDao;

//	@Autowired
//	MybatisDao dao;

	@Override
	public Object search(String json) throws Exception {
		// TODO Auto-generated method stub
		Object result=null;
		String sql = "select * from EMP";
		if (!StringUtils.isEmpty(json)) {
			try {
				Object jsonObject = GsonUtil.fromJson(json, EMP.class);
				result=jdbcDao.query(jsonObject);
			} catch (Exception e) {
				e.printStackTrace();
				return responseFailed();
			}
		}
		
		return responseSuccess(toJsonObject(result));
	}

	@Override
	public Object insert(String json) throws Exception {
		if (!StringUtils.isEmpty(json)) {
			try {
				Object jsonObject = GsonUtil.fromJson(json, EMP.class);
				jdbcDao.insert(jsonObject);
			} catch (Exception e) {
				e.printStackTrace();
				return responseFailed();
			}

		} else {
			return responseFailed();
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

	@Override
	public Object test(String json) throws Exception {
		System.out.println("success");
		return responseSuccess(defaultResponse());
	}

	@Override
	public Object testWithConsumes(String json) throws Exception {
		System.out.println(json);
		return responseSuccess(defaultResponse());
	}

	@Override
	public Object testWithNonConsumes(String json) throws Exception {
		System.out.println(json);
		return responseSuccess(defaultResponse());
	}

}
