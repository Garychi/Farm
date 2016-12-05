package com.it.generic;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.sql.JoinType;

public class MyCriteria extends DetachedCriteria {

	private static final long serialVersionUID = 6784912192726649256L;
	private Class entityClass;
	private Map<String, String> aliasMap = new HashMap();

	protected MyCriteria(String paramString1, String paramString2) {
		super(paramString1, paramString2);
	}

	protected MyCriteria(String paramString) {
		super(paramString);
	}

	public static MyCriteria forClass(Class paramClass) {
		MyCriteria localMyCriteria = new MyCriteria(paramClass.getName());
		localMyCriteria.setEntityClass(paramClass);
		return localMyCriteria;
	}

	public static MyCriteria forClass(Class paramClass, String paramString) {
		MyCriteria localMyCriteria = new MyCriteria(paramClass.getName(), paramString);
		localMyCriteria.setEntityClass(paramClass);
		return localMyCriteria;
	}

	public DetachedCriteria createAlias(String paramString1, String paramString2, JoinType paramJoinType, Criterion paramCriterion)
			throws HibernateException {
		this.aliasMap.put(paramString1 , paramString2);
		return super.createAlias(paramString1 , paramString2 , paramJoinType , paramCriterion);
	}

	public DetachedCriteria createAlias(String paramString1, String paramString2, JoinType paramJoinType)
			throws HibernateException {
		this.aliasMap.put(paramString1 , paramString2);
		return super.createAlias(paramString1 , paramString2 , paramJoinType);
	}

	public DetachedCriteria createAlias(String paramString1, String paramString2)
			throws HibernateException {
		this.aliasMap.put(paramString1 , paramString2);
		return super.createAlias(paramString1 , paramString2);
	}

	public DetachedCriteria createCriteria(String paramString1, String paramString2, JoinType paramJoinType, Criterion paramCriterion)
			throws HibernateException {
		this.aliasMap.put(paramString1 , paramString2);
		return super.createCriteria(paramString1 , paramString2 , paramJoinType , paramCriterion);
	}

	public DetachedCriteria createCriteria(String paramString1, String paramString2, JoinType paramJoinType)
			throws HibernateException {
		this.aliasMap.put(paramString1 , paramString2);
		return super.createCriteria(paramString1 , paramString2 , paramJoinType);
	}

	public DetachedCriteria createCriteria(String paramString1, String paramString2)
			throws HibernateException {
		this.aliasMap.put(paramString1 , paramString2);
		return super.createCriteria(paramString1 , paramString2);
	}

	public DetachedCriteria createCriteria(String paramString)
			throws HibernateException {
		this.aliasMap.put(paramString , "");
		return super.createCriteria(paramString);
	}

	private void setEntityClass(Class paramClass) {
		this.entityClass = paramClass;
	}

	public Class getEntityClass() {
		return this.entityClass;
	}

	public Map<String, String> getAliasMap() {
		return this.aliasMap;
	}
}
