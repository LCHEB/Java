package kr.kh.spring3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String list(Model model, Criteria cri) {
		cri.setPerPageNum(5);
		model.addAttribute("title", "게시글 목록");
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getBoardTotalCount(cri);
		PageMaker pm = new PageMaker(5, cri, totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String insert(Model model) {
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		model.addAttribute("list", list);
		model.addAttribute("title", "게시글 등록");
		return "/post/insert";
	}
	
	@PostMapping("/post/insert")
	public String insert(Model model, BoardVO board, 
			HttpServletRequest request, MultipartFile[] files) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(boardService.insertBoard(board,user,files)) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/post/list");
		}else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/post/insert");
		}
		return "message";
	}
}
