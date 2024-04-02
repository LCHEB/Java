package kr.kh.spring3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;
@Log4j
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("안녕하세요. 스프링 메인입니다.");
		int count = memberService.getMemberCount();
		log.info("등록된 회원 수 : " + count);
		return "/main/home";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("title", "회원가입");
		return "/member/signup";
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model,MemberVO member) {
		if(memberService.insertMember(member)) {
			model.addAttribute("msg","회원가입 성공");
			model.addAttribute("url","/");
		}else {
			model.addAttribute("msg","회원가입 실패");
			model.addAttribute("url","/signup");
		}
		return "message";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		user = memberService.login(member);
		if(user != null) {
			model.addAttribute("user", user);
			model.addAttribute("msg", "로그인 성공");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "로그인 실패");
			model.addAttribute("url", "/login");
		}
		return "message";
	}
	
}
