package kr.kh.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String list(Model model) {
		model.addAttribute("title", "게시글 목록");
		ArrayList<BoardVO> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "/post/list";
	}
	
}
