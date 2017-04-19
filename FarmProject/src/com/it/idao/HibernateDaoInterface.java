package com.it.idao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;

import com.it.generic.MyCriteria;

public abstract interface HibernateDaoInterface {
	 public abstract Query createQuery(String paramString);
	  
	  public abstract Query createQuery(String paramString, List<Object> paramList);
	  
	  public abstract Query createQuery(String paramString, Map<String, Object> paramMap);
	  
	  public abstract Criteria createCriteria(Class<?> paramClass);
	  
	  public abstract int updateByHQL(String paramString);
	  
	  public abstract int updateByHQL(String paramString, List<Object> paramList);
	  
	  public abstract int updateByHQL(String paramString, Map<String, Object> paramMap);
	  
	  public abstract Criteria createCriteria(MyCriteria paramCriteria);
	  
	  public abstract Query createQuery(Object object);
	  
	  public abstract int getRowCount(MyCriteria paramCriteria);
}
