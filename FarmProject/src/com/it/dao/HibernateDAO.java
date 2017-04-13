package com.it.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.exception.SysException;
import com.it.generic.MyCriteria;
import com.it.idao.DaoInterface;
import com.it.idao.HibernateDaoInterface;

@Repository("hibernateDao")
public class HibernateDAO implements HibernateDaoInterface, DaoInterface {

	private static Logger log = LogManager.getLogger(HibernateDAO.class);

	@Autowired
	protected SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public int update(String paramString) {

		return 0;
	}

	public int update(String paramString, List<Object> paramList) {

		return 0;
	}

	public List<Map<String, Object>> query(String paramString) {

		return null;
	}

	public Collection query(String paramString, int paramInt1, int paramInt2) {

		return null;
	}

	public Collection query(String paramString, List<Object> paramList) {

		return null;
	}

	public Collection query(String paramString, List<Object> paramList, int paramInt1, int paramInt2) {

		return null;
	}

	public int queryCount(String paramString) {

		return 0;
	}

	public int queryCount(String paramString, List<Object> paramList) {

		return 0;
	}

	public Object select1Record(String paramString) {

		return null;
	}

	public Object select1Record(String paramString, List<Object> paramList) {

		return null;
	}

	public int insert(Object paramObject) {
		int count = 0;

		if (paramObject != null) {
			try {
				getCurrentSession().save(paramObject);
				count++;
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new SysException(e.getMessage());
			}
		}

		return count;
	}

	public int insertByBeanCollection(Collection<?> paramCollection) {
		int i = 0;
		try {
			Iterator localIterator = paramCollection.iterator();
			while (localIterator.hasNext()) {
				Object localObject = localIterator.next();
				getCurrentSession().save(localObject);
				i++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new SysException(e.getMessage());
		}
		return i;
	}

	public int update(Object paramObject) {

		return 0;
	}

	public int updateByBeanCollection(Collection<?> paramCollection) {

		return 0;
	}

	public int delete(Object paramObject) {

		return 0;
	}

	public int deleteByBeanCollection(Collection paramCollection) {

		return 0;
	}

	public Object refreshObject(Object paramObject) {

		return null;
	}
	
	public Query createQuery(String paramString) {
		Query localQuery = null;
		try {
			localQuery = getCurrentSession().createQuery(paramString);
		}
		catch (IllegalArgumentException localIllegalArgumentException) {
			localIllegalArgumentException.printStackTrace();
			log.error(localIllegalArgumentException.getMessage());
		}
		return localQuery;
	}

	public Query createQuery(String paramString, List<Object> paramList) {

		return null;
	}

	public Query createQuery(String paramString, Map<String, Object> paramMap) {

		return null;
	}

	public Criteria createCriteria(Class<?> paramClass) {

		return null;
	}

	public int updateByHQL(String paramString) {

		return 0;
	}

	public int updateByHQL(String paramString, List<Object> paramList) {

		return 0;
	}

	public int updateByHQL(String paramString, Map<String, Object> paramMap) {

		return 0;
	}

	public Criteria createCriteria(MyCriteria paramDwCriteria) {

		return null;
	}

	public int getRowCount(MyCriteria paramDwCriteria) {

		return 0;
	}

}
