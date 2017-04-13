package com.webservice.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.it.dao.HibernateDAO;
import com.webservice.DefaultResponse;
import com.webservice.header.IProduct;

public class ProductService extends DefaultResponse implements IProduct{	
	@Autowired
	HibernateDAO hibernateDao;
	
	@Transactional
	@Override
	public Object search(String json) throws Exception {
		Object result = null;
		if (!StringUtils.isEmpty(json)) {
			try {
				String paramString = "select model from Product model ";
				result =hibernateDao.createQuery(paramString).list();
			} catch (Exception e) {
				e.printStackTrace();
				return responseFailed();
			}
		} else {
			return responseFailed();
		}

		return responseSuccess(toJsonObject(result));
	}

	@Override
	public Object insert(String json) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	public void getDescription() {
		// TODO Auto-generated method stub
		
	}

}
