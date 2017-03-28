package com.it.idao;

import java.util.List;
import java.util.Map;

public abstract interface JdbcGenericDaoInterface {
	public abstract int updateBean(Object paramObject);
	  
	  public abstract Object queryByPK(Object paramObject);
	  
	  public abstract List<?> query(Object paramObject);
	  
	  public abstract List<?> query(Object paramObject, int paramInt1, int paramInt2);
	  
	  public abstract List<?> query(Class<?> paramClass, String paramString);
	  
	  public abstract List<?> query(Class<?> paramClass, String paramString, Map<String, String> paramMap);
	  
	  public abstract List<?> query(Class<?> paramClass, String paramString, List<Object> paramList);
	  
	  public abstract List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, Map<String, String> paramMap);
	  
	  public abstract List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, int paramInt);
	  
	  public abstract List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, int paramInt, Map<String, String> paramMap);
	  
	  public abstract List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, int paramInt1, int paramInt2);
	  
	  public abstract List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, int paramInt1, int paramInt2, Map<String, String> paramMap);
	  
	  public abstract List<List<?>> query(Class<?>[] paramArrayOfClass, String paramString);
	  
	  public abstract List<List<?>> query(Class<?>[] paramArrayOfClass, String paramString, List<Object> paramList);
	  
	  public abstract List<List<?>> query(Class<?>[] paramArrayOfClass, String paramString, List<Object> paramList, int paramInt);
	  
	  public abstract List<List<?>> query(Class<?>[] paramArrayOfClass, String paramString, List<Object> paramList, int paramInt1, int paramInt2);
}
