package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(MemberVO member);

	MemberVO selectMember(@Param("id")String me_id);

}
