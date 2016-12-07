package com.it.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.it.exception.SysException;
import com.it.idao.JdbcDaoInterface;
import com.it.utils.SqlCollector;

@Repository("jdbcDao")
public class JdbcDao implements JdbcDaoInterface {
	private static Logger log = LogManager.getLogger(JdbcDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcDao() {
	}

	public int updateBean(Object paramObject) {

		return 0;
	}

	public Object queryByPK(Object paramObject) {

		return null;
	}

	public List<?> query(Object paramObject) {

		return null;
	}

	public List<?> query(Object paramObject, int paramInt1, int paramInt2) {

		return null;
	}

	public List<?> query(Class<?> paramClass, String paramString) {

		return null;
	}

	public List<?> query(Class<?> paramClass, String paramString, Map<String, String> paramMap) {

		return null;
	}

	public List<?> query(Class<?> paramClass, String paramString, List<Object> paramList) {

		return null;
	}

	public List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, Map<String, String> paramMap) {

		return null;
	}

	public List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, int paramInt) {

		return null;
	}

	public List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, int paramInt, Map<String, String> paramMap) {

		return null;
	}

	public List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, int paramInt1, int paramInt2) {

		return null;
	}

	public List<?> query(Class<?> paramClass, String paramString, List<Object> paramList, int paramInt1, int paramInt2, Map<String, String> paramMap) {

		return null;
	}

	public List<List<?>> query(Class<?>[] paramArrayOfClass, String paramString) {

		return null;
	}

	public List<List<?>> query(Class<?>[] paramArrayOfClass, String paramString, List<Object> paramList) {

		return null;
	}

	public List<List<?>> query(Class<?>[] paramArrayOfClass, String paramString, List<Object> paramList, int paramInt) {

		return null;
	}

	public List<List<?>> query(Class<?>[] paramArrayOfClass, String paramString, List<Object> paramList, int paramInt1, int paramInt2) {

		return null;
	}

	public int update(String paramString) {
		ArrayList localArrayList = new ArrayList();
		return update(paramString , localArrayList);
	}

	public int update(String paramString, List<Object> paramList) {
		int i = 0;
		try {
			// paramString = this.manageService.addManageColumn(paramString, paramList);
			Object[] arrayOfObject = paramList.toArray();
			i = this.jdbcTemplate.update(paramString , arrayOfObject);
		}
		catch (IllegalArgumentException localIllegalArgumentException) {
			log.error(localIllegalArgumentException.getMessage());
			localIllegalArgumentException.printStackTrace();
			throw new SysException(localIllegalArgumentException);
		}
		// catch (IllegalAccessException localIllegalAccessException) {
		// log.error(localIllegalAccessException.getMessage());
		// localIllegalAccessException.printStackTrace();
		// throw new SystemException(localIllegalAccessException);
		// }
		return i;
	}

	public Collection<?> query(String paramString) {
		String sql ="select * from T_A_ORG";
		List<Map<String,Object>> result= (List<Map<String, Object>>) jdbcTemplate.queryForList(sql);
		
		if(result !=null){
			return result;
		}
		
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
		int i = 0;
		try {
			// SqlCollector localSqlCollector = SQLStringUtils.getInsertSqlByBean(paramObject);
			SqlCollector localSqlCollector =new SqlCollector();
			i = this.jdbcTemplate.update(localSqlCollector.getSql() , localSqlCollector.getParam().toArray());
		}
		catch (IllegalArgumentException localIllegalArgumentException) {
			localIllegalArgumentException.printStackTrace();
			log.error(localIllegalArgumentException.getMessage());
			throw new SysException(localIllegalArgumentException);
		}
		return i;
	}

	public int insertByBeanCollection(Collection<?> paramCollection) {

		return 0;
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

}
