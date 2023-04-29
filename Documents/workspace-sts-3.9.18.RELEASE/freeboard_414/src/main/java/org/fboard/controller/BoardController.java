package org.fboard.controller;  //23년 04월17일,19일 수업

import org.fboard.domain.BoardDTO;
import org.fboard.domain.Criteria;
import org.fboard.domain.PageDTO;
import org.fboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	//@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list : " + cri);
		long total = service.getTotal(cri);
		log.info("******** total ***"+total);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	
	}
	
	@GetMapping("/register") //23년 04월 19일 수업
	public void register() {
		
	}
	
	
	@PostMapping("/register")
	public String register(BoardDTO dto, RedirectAttributes rttr) {
		log.info("#### register: " + dto);
		
		service.register(dto);
		rttr.addFlashAttribute("result",dto.getBno());
		
		
		return "redirect:/board/list"; 
	}
	
	@GetMapping({"/get", "/modify"})
	public void get( long bno,@ModelAttribute("cri") Criteria cri , Model model) { //@RequestParam("bno") 혹시 값이 안넘겨질시 붙이면 확실히 넘어감.
		log.info("!@#$% get or modify:... " + bno);
		model.addAttribute("dto",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO dto, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr ) {
		log.info("!@#$% modify:... " + dto);
		
		if(service.modify(dto)) {
			rttr.addFlashAttribute("result","success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("pageNum", cri.getAmount());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("!@#$% remove:... " + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("pageNum", cri.getAmount());
		
		return "redirect:/board/list";
	}
	
}
