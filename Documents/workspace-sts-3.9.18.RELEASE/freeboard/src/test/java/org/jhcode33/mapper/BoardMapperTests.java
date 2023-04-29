package org.jhcode33.mapper;

import org.jhcode33.domain.BoardDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//ContextConfiguration을 Configuration으로 하니까 JUnit test가 안됨. 오류해결ㅎㅎ
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	//객체 자동 주입
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;

	//@Ignore 테스트를 막는 어노테이션
	@Ignore
	public void testGetList() {
		log.info("testGetList 실행");
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Ignore
	public void testInsert() {
		log.info("testInsert 실행");
		BoardDTO tmp = new BoardDTO();
		tmp.setTitle("자바의 정석");
		tmp.setContent("java content");
		tmp.setWriter("lee");
		
		mapper.insert(tmp);
		//현재 tmp은 현재 어떤 값이 들어가있는지만 보여준다, DB에 정보가 저장되어야지 seq_board.nextval과 sysdate가 들어간다.
		log.info(tmp);
	}
	
	//javascript에서 몇번째 글이 저장됬는지 출력하게하기 위해 다음과 같이 코드를 작성하였음.
	@Ignore
	public void testInsertSelectKey() {
		log.info("testInsert 실행");
		BoardDTO tmp = new BoardDTO();
		tmp.setTitle("자바의 정석3");
		tmp.setContent("java content3");
		tmp.setWriter("lee");
		
		mapper.insertSelectKey(tmp);
		//현재 tmp은 현재 어떤 값이 들어가있는지만 보여준다, DB에 정보가 저장되어야지 seq_board.nextval과 sysdate가 들어간다.
		log.info(tmp);
	}
	
	@Ignore
	public void testGetOne() {
		//L 을 적어서 long타입임을 명시함.
		BoardDTO tmp = mapper.getOne(2L);
		log.info(tmp);
	}
	
	@Ignore
	public void testDelete() {
		//delete를 수행했을 때 쿼리를 수행한 결과의 개수를 반환함.
		log.info("삭제한 개수: " +mapper.delete(7));
	}
	
	@Ignore
	public void testUpdate() {
		BoardDTO tmp = new BoardDTO();
		tmp.setBno(7L);
		tmp.setTitle("update 수행");
		tmp.setContent("수정");
		tmp.setWriter("수정이");
		
		log.info("수행한 쿼리의 개수: "+mapper.update(tmp));
		log.info(tmp);
	}
	
	//제목으로 검색
	@Test
	public void testSearchTitle() {
		mapper.searchTitle("제목").forEach(board -> log.info(board));
	}
	
	
}
