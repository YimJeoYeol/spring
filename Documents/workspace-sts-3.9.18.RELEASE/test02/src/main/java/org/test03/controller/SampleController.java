package org.test03.controller;


import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test03.domain.SampleDTOList;
import org.test03.domain.SampleDto;
import org.test03.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/ex01")
	public String ex01(SampleDto dto) {
		log.info(dto);
		
		return "exam";
	}
	
	/*
	 * @RequestMapping(value="/basic", method= {RequestMethod.GET,
	 * RequestMethod.POST}) public void basic() { log.info("basic........."); }
	 */
	
	@GetMapping("/basicGet")
	public void basicGet() {
		log.info("basicGet().........");
	}
	
	@GetMapping("/basicPost")
	public void basicPost() {
		log.info("basicPost().........");
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name ") String name, @RequestParam("age") int age, @RequestParam("birth")  String birth){
		log.info("name : " + name);
		log.info("age :  " + age);
		log.info("birth :  " + birth);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(@RequestParam("ids") String[] ids) {
		log.info("ids" + Arrays.toString(ids));
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTOList list) {
		log.info("list ots:" + list);
		return "ed04";
	}
	@GetMapping("/ex05")
	public String ex05(TodoDTO todo) {
		log.info("todo : "+todo);
		return "ed05";
	}
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dataFormat = new SimpleDateFormat("yyyy/mm/dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dataFormat, false)); }
	 */
	
	@GetMapping("/ex06")
	public String ex06(SampleDto dto, @ModelAttribute("page") int page) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		return "ex06";
	}
	@GetMapping("/ex07")
	public @ResponseBody SampleDto ex07() {
		log.info("ex07............");
		SampleDto dto = new SampleDto();
		dto.setName("king");
		dto.setAge(58);
		return dto;
	}
	@GetMapping("/ex08")
	public ResponseEntity<String> ex08(){
		log.info("ex08..................");
		String msg="{\"name\" : \" hong\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Conetent-Type", "application/json:charset=UTF-8");
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
}