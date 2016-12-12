package com.webservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.it.dao.JdbcDao;
import com.it.mybatis.MybatisDao;
import com.it.utils.GsonUtil;
import com.model.EMP;
//import com.model.TAOrg;
import com.webservice.DefaultResponse;
import com.webservice.header.IOrgService;

import net.sf.json.JSONObject;

public class OrgService extends DefaultResponse implements IOrgService {

	@Autowired
	JdbcDao jdbcDao;

//	@Autowired
//	MybatisDao mybatisDao;

	@Override
	public Object search(String json) throws Exception {
		String sql = "select * from T_A_ORG ";
		
		if (!StringUtils.isEmpty(json)) {
			try {
				JSONObject jsonObject =JSONObject.fromObject(json);
				jdbcDao.query(jsonObject);
				//jdbcDao.insert(jsonObject);
			} catch (Exception e) {
				e.printStackTrace();
				return responseFailed();
			}
		}
		else{
			return responseFailed();
		}
		
		List<Map<String, Object>> result = jdbcDao.query(sql);

		return responseSuccess(toJsonObject(result));
	}

	@Override
	public Object insert(String json) throws Exception {
		if (!StringUtils.isEmpty(json)) {
			try {
//				Object jsonObject = GsonUtil.fromJson(json, TAOrg.class);
//				jdbcDao.insert(jsonObject);
			} catch (Exception e) {
				e.printStackTrace();
				return responseFailed();
			}
		} 
		else {
			return responseFailed();
		}

		return responseSuccess(defaultResponse());
	}

}
