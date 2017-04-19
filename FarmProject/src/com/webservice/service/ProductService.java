package com.webservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.gson.JsonSyntaxException;
import com.it.dao.HibernateDAO;
import com.it.utils.GsonUtil;
import com.model.Product;
import com.webservice.DefaultResponse;
import com.webservice.header.IProduct;

public class ProductService extends DefaultResponse implements IProduct {

	private static final Logger logger = LogManager.getLogger(ProductService.class);

	// @Autowired
	// JdbcDao jdbcDao;

	@Autowired
	HibernateDAO hibernateDao;

	@Transactional
	@Override
	public Object search(String json) throws Exception {
		Object result = null;
		// logger.info("--------into search----------");

		if (!StringUtils.isEmpty(json)) {
			try {

				Object jsonObject = GsonUtil.fromJson(json, Product.class);
				// HQLGenerator HQLGenerator = new HQLGenerator(jsonObject);

				String paramString = "select model from Product model ";
				result = hibernateDao.createQuery(paramString).list();
				// logger.info("--------end search----------");
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
		Object result = null;
		if (!StringUtils.isEmpty(json)) {
			try {
				Object jsonObject = GsonUtil.fromJson(json, Product.class);
				hibernateDao.insert(jsonObject);
			} catch (JsonSyntaxException e) {
				logger.info(e.getCause());
				return responseFailed();
			} catch (Exception e) {
				logger.info(e.getMessage());
				return responseFailed();
			}
		} else {
			return responseFailed();
		}

		return responseSuccess(toJsonObject(result));
	}

	@Transactional
	@Override
	public Object update(String json) throws Exception {
		Object result = null;
		if (!StringUtils.isEmpty(json)) {
			try {
				Object jsonObject = GsonUtil.fromJson(json, Product.class);
				hibernateDao.update(jsonObject);
			} catch (Exception e) {
				logger.info("product update error");
				return responseFailed();
			}
		} else {
			return responseFailed();
		}

		return responseSuccess(toJsonObject(result));
	}

	@Transactional
	@Override
	public Object delete(String json) throws Exception {
		Object result = null;
		if (!StringUtils.isEmpty(json)) {
			try {
				Object jsonObject = GsonUtil.fromJson(json, Product.class);
				hibernateDao.delete(jsonObject);
			} catch (Exception e) {
				logger.info("product delete error");
				return responseFailed();
			}
		} else {
			return responseFailed();
		}

		return responseSuccess(toJsonObject(result));
	}

	@Override
	public void getDescription() {
		// TODO Auto-generated method stub

	}

}
