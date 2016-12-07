package com.it.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisDao {

	/**
	 * Mybatis session factory
	 */
	@Autowired
	private SqlSessionFactoryBean sessionFactoryBean;
	
	/**
	 * Mybatis session factory
	 */
	private SqlSessionFactory sessionFactory;

	/**
	 * 取得 session factory
	 * @return session factory
	 * @throws Exception 異常
	 */
	private SqlSessionFactory getSessionFactory() throws Exception {
		
		if (this.sessionFactory == null) {
			
			this.initSessionFactory();
		}
		
		return this.sessionFactory;
	}
	
	/**
	 * 初始化 session factory
	 * @throws Exception 
	 */
	private void initSessionFactory() throws Exception {

		if (this.sessionFactory == null) {
		
			this.sessionFactory = sessionFactoryBean.getObject();
		}
	}
	
	/**
	 * 執行
	 * @param sqlId SQL 編號
	 * @param parameter 參數
	 * @return 結果
	 * @throws Exception 異常
	 */
	public <T> List<T> execute(String sqlId, Object parameter) throws Exception {
		
		SqlSession session = this.getSessionFactory().openSession();
		return session.selectList(sqlId, parameter);
	}
}
