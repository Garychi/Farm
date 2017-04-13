package com.it.dao.init;

import org.hibernate.SessionFactory;

public abstract interface HibernateDynamicSessionFactory extends SessionFactory {
	public abstract SessionFactory getHibernateSessionFactory();
}