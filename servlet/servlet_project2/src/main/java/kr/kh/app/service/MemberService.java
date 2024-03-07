package kr.kh.app.service;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(LoginDTO loginDTO);

	String checkId(String id);

}
