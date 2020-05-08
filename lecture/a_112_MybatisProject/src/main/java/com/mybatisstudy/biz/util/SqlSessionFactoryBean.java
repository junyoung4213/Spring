package com.mybatisstudy.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* SqlSessionFactoryBuilder는 "sql-map-config.xml"를 
 * 읽어서 SqlSessionFactory객체를 생성한다
 * SqlSessionFactory객체는 openSession()를 통해서
 * SqlSession객체를 리턴한다.
 * 
 * 우리는 SqlSession을 통해서 
 * mapper XML에 설정한 sql문을 지정할 수 있고
 * DB에 전달할 수 있다.
*/
public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory = null;
	
	static {
		try {
			if(sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory=new SqlSessionFactoryBuilder().build(reader);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession();
	}
}
