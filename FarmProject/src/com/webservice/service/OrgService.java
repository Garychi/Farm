package com.webservice.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.it.dao.JdbcDao;
import com.it.utils.GsonUtil;
import com.model.TAOrg;
//import com.model.TAOrg;
import com.webservice.DefaultResponse;
import com.webservice.header.IOrgService;

public class OrgService extends DefaultResponse implements IOrgService {

	@Autowired
	JdbcDao jdbcDao;

	// @Autowired
	// MybatisDao mybatisDao;

	@Override
	public Object search(String json) throws Exception {
		// String sql = "select * from T_A_ORG ";
		Object result = null;
		if (!StringUtils.isEmpty(json)) {
			try {
				// JSONObject jsonObject =JSONObject.fromObject(json);
				Object jsonObject = GsonUtil.fromJson(json, TAOrg.class);
				result = jdbcDao.query(jsonObject);

			} catch (Exception e) {
				e.printStackTrace();
				return responseFailed();
			}
		} else {
			return responseFailed();
		}

		return responseSuccess(toJsonObject(result));
	}

	@Transactional
	@Override
	public Object insert(String json) throws Exception {
		if (!StringUtils.isEmpty(json)) {
			try {
				TAOrg tAOrg = (TAOrg) GsonUtil.fromJson(json, TAOrg.class);
				tAOrg.setOrgCode("G1234");		
				tAOrg.setCompany("company");
				tAOrg.setCreator("user001");
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				
				Timestamp ts=new Timestamp(new Date().getTime());
				tAOrg.setCreateDate(ts);
				tAOrg.setDataSource("1");
				tAOrg.setTenantGroup("28682266");
				jdbcDao.insert(tAOrg);
			} catch (Exception e) {
				e.printStackTrace();
				return responseFailed();
			}
		} else {
			return responseFailed();
		}

		return responseSuccess(defaultResponse());
	}

}
