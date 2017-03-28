package com.it.idao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract interface DaoInterface {
	public abstract int update(String paramString);

	public abstract int update(String paramString, List<Object> paramList);

	public abstract List<Map<String,Object>> query(String paramString);

	public abstract Collection query(String paramString, int paramInt1, int paramInt2);

	public abstract Collection query(String paramString, List<Object> paramList);

	public abstract Collection query(String paramString, List<Object> paramList, int paramInt1, int paramInt2);

	public abstract int queryCount(String paramString);

	public abstract int queryCount(String paramString, List<Object> paramList);

	public abstract Object select1Record(String paramString);

	public abstract Object select1Record(String paramString, List<Object> paramList);

	public abstract int insert(Object paramObject);

	public abstract int insertByBeanCollection(Collection<?> paramCollection);

	public abstract int update(Object paramObject);

	public abstract int updateByBeanCollection(Collection<?> paramCollection);

	public abstract int delete(Object paramObject);

	public abstract int deleteByBeanCollection(Collection paramCollection);

	public abstract Object refreshObject(Object paramObject);
}
