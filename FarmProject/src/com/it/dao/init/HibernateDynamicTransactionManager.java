package com.it.dao.init;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

public class HibernateDynamicTransactionManager extends HibernateTransactionManager {
	private static final long serialVersionUID = 4088753241017722812L;

	public HibernateDynamicTransactionManager() {
	}

	public DataSource getDataSource() {
		return SessionFactoryUtils.getDataSource(getSessionFactory());
	}

	public SessionFactory getSessionFactory() {
		HibernateDynamicSessionFactory localHibernateDynamicSessionFactory = (HibernateDynamicSessionFactory) super.getSessionFactory();
		return localHibernateDynamicSessionFactory.getHibernateSessionFactory();
	}
}
