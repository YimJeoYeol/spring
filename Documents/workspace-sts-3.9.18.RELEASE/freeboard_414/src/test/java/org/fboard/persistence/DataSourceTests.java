package org.fboard.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

//import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
@Log4j
public class DataSourceTests { //2단계
	
	@Setter(onMethod_ = {@Autowired})
	private DataSource ds;
	
	
	@Test
	public void testConnection() {
		try {
			Connection conn = ds.getConnection();
			log.info("%^&"+conn);
		} catch(Exception e) {
			log.info(e.getMessage());
			fail(e.getMessage());
			
		}
	}
}









