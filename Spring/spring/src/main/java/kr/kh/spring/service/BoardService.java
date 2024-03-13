package kr.kh.spring.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(@Param("cri")Criteria cri);


}
