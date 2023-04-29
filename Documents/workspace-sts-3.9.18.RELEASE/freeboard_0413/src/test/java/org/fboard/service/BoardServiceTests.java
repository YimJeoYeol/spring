package org.fboard.service; //23년 04월 17일 수업

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.fboard.domain.BoardDTO;
import org.fboard.domain.Criteria;
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
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	//@Test
	public void testExist() {
		assertNotNull(service);
		log.info("###"+service);
	}
	//@Test
	public void testRegister() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("스프링 등록");
		dto.setContent("스프링 등록 내용.....");
		dto.setWriter("???");
		
		service.register(dto);
		
		log.info("***** 생성된 게시물의 번호: " + dto.getBno());
	}
	@Test
	public void testGetList() {
		//for(BoardDTO one : service.getList()) {
		//	log.info("*********: "+one);
		//}(2단계)
		//service.getList()이것만 적어도 무방(1단계)
		service.getList(new Criteria(2, 10)).forEach(one -> log.info("### : " + one)); //또다른 방법
	
	}
	
	//@Test
	public void testGet() {
		log.info("@@@@ get: " + service.get(10L));
	}
	
	//@Test
	public void testModify() {
		BoardDTO dto = new BoardDTO();
		dto.setBno(5L);
		dto.setTitle("스프링 수정수정");
		dto.setContent("수정 수정 내용..수정...");
		dto.setWriter("???!!!");
		
		service.modify(dto);
		
		log.info("*****수정된 게시물의 번호: " + service.modify(dto));
	}
	//@Test
	public void testRemove() {
		log.info("!!!!!!!!!! remove: " + service.remove(5L));
	}
}





















