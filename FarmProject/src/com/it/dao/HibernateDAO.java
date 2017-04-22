package com.it.dao;

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
			} catch (Exception e) {
//				log.error(e.getMessage());
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
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new SysException(e.getMessage());
		}
		return i;
	}

	public int update(Object paramObject) {

		return 0;
	}

	public int updateByBeanCollection(Collection<?> paramCollection) {
		int i = 0;
		try {
			Iterator localIterator = paramCollection.iterator();
			while (localIterator.hasNext()) {
				Object localObject = localIterator.next();
				getCurrentSession().update(localObject);
				i++;
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new SysException(e.getMessage());
		}
		return i;
	}

	public int delete(Object paramObject) {
		try{
			getCurrentSession().delete(paramObject);
		}
		catch(Exception e){
			log.info(e.getMessage());
			throw new SysException(e.getMessage());
		}
		return 0;
	}

	public int deleteByBeanCollection(Collection paramCollection) {
		int i = 0;
		try {
			Iterator localIterator = paramCollection.iterator();
			while (localIterator.hasNext()) {
				Object localObject = localIterator.next();
				getCurrentSession().delete(localObject);
				i++;
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new SysException(e.getMessage());
		}
		return i;
	}

	public Object refreshObject(Object paramObject) {

		return null;
	}

	public Query createQuery(String paramString) {
		Query localQuery = null;
		try {
			localQuery = getCurrentSession().createQuery(paramString);
		} catch (IllegalArgumentException localIllegalArgumentException) {
			localIllegalArgumentException.printStackTrace();
			log.error(localIllegalArgumentException.getMessage());
		}
		return localQuery;
	}

	public Query createQuery(String paramString, List<Object> paramList) {
		
		return null;
	}

	public Query createQuery(String paramString, Map<String, Object> paramMap) {
		Query localQuery = null;
		try {
			localQuery = getCurrentSession().createQuery(paramString);
			
			for(String param :localQuery.getNamedParameters()){
				localQuery.setParameter(param, paramMap.get(param));
			}
			
		} catch (IllegalArgumentException localIllegalArgumentException) {
			localIllegalArgumentException.printStackTrace();
			log.error(localIllegalArgumentException.getMessage());
		}
		return localQuery;
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

	public Criteria createCriteria(MyCriteria paramCriteria) {

		return null;
	}

	public int getRowCount(MyCriteria paramCriteria) {

		return 0;
	}

	public Query createQuery(Object paramObject) {
		// select model from Product model where 1=1 and model.id.prodCode =?
		// and model.id.compCode=?
		StringBuffer hql = new StringBuffer();
		Query localQuery = null;
		try {
			localQuery = getCurrentSession().createQuery(hql.toString());
		} catch (IllegalArgumentException localIllegalArgumentException) {
			localIllegalArgumentException.printStackTrace();
			log.error(localIllegalArgumentException.getMessage());
		}

		return localQuery;
	}

}
