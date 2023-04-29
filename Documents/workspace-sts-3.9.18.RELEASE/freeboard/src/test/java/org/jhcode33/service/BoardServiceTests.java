package org.jhcode33.service;

import static org.junit.Assert.assertNotNull;

import org.jhcode33.domain.BoardDTO;
import org.jhcode33.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = {@Autowired} )
	private BoardService service;
	
	//@Test
	public void testExist() {
		assertNotNull(service);
		log.info("*****"+service);
	}
	
	//@Test
	public void testRegister() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("스프링 등록");
		dto.setContent("스프링 서비스 등록호출... ");
		dto.setWriter("임재열");
		
		service.register(dto);
		
		log.info("***생성된 게시물의 번호 : " + dto.getBno());
	}
	//@Test
	public void testgetList(){
		/*
		 * for(BoardDTO tmp : service.getList()) { log.info("****** : " + tmp); }
		 */
		/* service.getList(); */
		
		
		service.getList().forEach(tmp -> log.info(tmp));
	}
	
	//@Test
	public void testGet() {
		
		log.info("*********" + service.get(21L));
	}
	@Test
	public void testModify() {
		BoardDTO dto = new BoardDTO();
		dto.setBno(1L);
		dto.setTitle("서비스 제목 수정");
		dto.setContent("서비스 내용 수정... ");
		dto.setWriter("user00");
		
		//service.modify(dto);
		log.info("modify.........." + dto);
		
		log.info("***생성된 게시물의 번호 : " + dto.getBno());
	}
	//@Test
	public void testRemove() {
		log.info("****remove : " + service.remove(1L));
	}
}
