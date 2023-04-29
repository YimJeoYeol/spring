package org.fboard.mapper;

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
public class BoardMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	//@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	//@Test 
	public void testinsert() {
		BoardDTO tmp = new BoardDTO();
		tmp.setTitle("java의 정석");
		tmp.setContent("java의 정석 내용");
		tmp.setWriter("남궁성");
		
		mapper.insert(tmp);
		log.info(tmp);	
	}
	//@Test
	public void insertSelectKey() {
		BoardDTO tmp = new BoardDTO();
		tmp.setTitle("java의 정석3");
		tmp.setContent("java의 정석 내용3");
		tmp.setWriter("남궁성3");
		
		mapper.insertSelectKey(tmp);
		log.info(tmp);	
	}
	//@Test
	public void testGetOne() {
		BoardDTO tmp = mapper.getOne(6L); //L이나 l을 써서 long타입이라고 설명해줌(안하면 int로 생각함)
		
		log.info(tmp);	
	}
	
	//@Test
	public void testDelete() {
		log.info("delete cnt: " + mapper.delete(6L));
	}
	
	//@Test
	public void testupdate() {
		BoardDTO tmp = new BoardDTO();
		tmp.setBno(2L);
		tmp.setTitle("수정");
		tmp.setContent("수정의 정석 내용");
		tmp.setWriter("준열");
		
		log.info("update cnt: " + mapper.update(tmp));
	}
	
	//@Test
	public void testSearchTitle() {
		mapper.searchTitle("자바").forEach(board -> log.info(board));
	}
	@Test
	public void testPaging() {
		Criteria cri = new Criteria(3,10);
		mapper.getListWithPaging(cri).forEach(board -> log.info(board));
	}
}



















