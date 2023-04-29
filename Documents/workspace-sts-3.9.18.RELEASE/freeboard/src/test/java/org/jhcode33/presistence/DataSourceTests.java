package org.jhcode33.presistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//HikariCP로 연결이 되는지 확인하는 코드임.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	@Setter(onMethod_ = {@Autowired})
	private DataSource ds;
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory ssf;
	
	//@Test
	public void testConnection() {
		try {
			Connection conn = ds.getConnection();
			log.info("내가 만든 객체"+conn);
		} catch (Exception e) {
			log.info(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testMyBatis() {
		try {
			SqlSession sqlSession = ssf.openSession();
			Connection conn = sqlSession.getConnection();
			log.info("MyBatis연동"+conn);
			log.info("MyBatis연동"+sqlSession);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
