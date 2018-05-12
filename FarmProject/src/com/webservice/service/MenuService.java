package com.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.it.dao.HibernateDAO;
import com.it.utils.GsonUtil;
import com.model.Product;
import com.webservice.DefaultResponse;
import com.webservice.header.IMenu;

public class MenuService extends DefaultResponse implements IMenu {

	@Autowired
	HibernateDAO hibernateDao;

	@Transactional
	@Override
	public Object getMenu(String json) throws Exception {
		Object result = null;
		if (!StringUtils.isEmpty(json)) {
			try {

				Object jsonObject = GsonUtil.fromJson(json, Product.class);
				// HQLGenerator HQLGenerator = new HQLGenerator(jsonObject);

				String paramString = "select model from Menu model ";
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

}
