package com.webservice.service;

import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.it.dao.HibernateDAO;
import com.it.utils.GsonUtil;
import com.model.TokenFactory;
import com.webservice.DefaultResponse;
import com.webservice.header.ILoginService;

public class LoginService extends DefaultResponse implements ILoginService {
	private static Logger log = LogManager.getLogger(LoginService.class);

	@Autowired
	HibernateDAO hibernateDao;

	@Transactional(readOnly=true)
	@Override
	public Object checkIdentity(String json) throws Exception {
		Object result = null;

		if (!StringUtils.isEmpty(json)) {
//			String loginStatus="Account or Password is wrong , please check again";
			try {
				Map<String, Object> paramMap = (Map<String, Object>) GsonUtil.fromJson(json, Map.class);
				StringBuffer hql = new StringBuffer();
				hql.append("select model from Userinfo model where 1=1");
				hql.append(" and model.id.userName =:userName and model.id.password =:password");

				result = hibernateDao.createQuery(hql.toString(), paramMap).list();
				if(result !=null){
					TokenFactory tokenFactory = new TokenFactory();
					String token = tokenFactory.generateToken(json);
					
//					loginStatus="Login Success";
					
					StatusType status=result !=null ? Status.OK : Status.NO_CONTENT;
					
					ResponseBuilder builder = Response.status(status).entity(toJsonObject(token));
					builder.header("Content-Type", "application/json;charset=UTF-8");
//					builder.header("Authorization ", token);
					// 生成Response
					Response response = builder.build();

					// 回傳Response
					return response;	
				}

			} catch (Exception e) {
				log.info(e.getMessage());
				responseFailed();
			}
		} else {
			responseFailed();
		}

		return responseSuccess(toJsonObject(result));
	}

}
