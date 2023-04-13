package org.test03.sample;

import static org.junit.Assert.assertNotNull;

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
public class SampleTests {
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant rest;
	
	@Setter(onMethod_ = {@Autowired})
	private Chef cf;
	
	//@Test
	public void testExist() {
		assertNotNull(rest);
		
		log.info(rest);
		log.info(rest.getChef());
	}
	
	@Test
	public void testExist2() {
		assertNotNull(cf);
		cf.setName("홍길동");
		log.info(cf.getName());
	}
}
