package org.fboard.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc; //mockup 시제품(테스트를 하기 위한 가상의 MVC)
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) 
//2가지 파일을 읽어올시 배열로 집어 넣어야 된다.
@Log4j
public class BoardControllerTests {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockmvc; //가상이기에 직접 데이터를 넣는 작업이 필요함
	
	@Before
	public void setUp() {
		this.mockmvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	//@Test
	public void testList() throws Exception {
		log.info("####: " + mockmvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	
	}
	//@Test
	public void testRegister() throws Exception {
		String resultPage = mockmvc.perform(MockMvcRequestBuilders.post("/board/register")
											.param("title", "목업 죄목")
											.param("content", "목업 내용")
											.param("writer", "???"))
							.andReturn()
							.getModelAndView()
							.getViewName();
		log.info("!@#$%: " + resultPage);
		
	}
	//@Test
	public void testGet() throws Exception {
		log.info("####: " + mockmvc.perform(MockMvcRequestBuilders.get("/board/get")
							.param("bno", "3"))
					.andReturn()
					.getModelAndView()
					.getModelMap());
		
	}
	
	//@Test
	public void testModify() throws Exception {
		String resultPage = mockmvc.perform(MockMvcRequestBuilders.post("/board/modify")
									.param("bno", "99")
									.param("title", "목업 죄목2")
									.param("content", "목업 내용2")
									.param("writer", "???2"))
							.andReturn()
							.getModelAndView()
							.getViewName();
		log.info("!@#$%: " + resultPage);

	}
	
	//@Test
	public void testRemove() throws Exception {
		String resultPage = mockmvc.perform(MockMvcRequestBuilders.get("/board/remove")
									.param("bno", "15"))
							.andReturn()
							.getModelAndView()
							.getViewName();
		log.info("!@#$%: " + resultPage);
	}
	@Test
	public void testListPaging() throws Exception{
		log.info("**********"+ mockmvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "7"))
		.andReturn()
		.getModelAndView()
		.getModelMap());
	}
		
}
