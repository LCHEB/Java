package kr.kh.spring3.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.pagination.Criteria;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectBoardTotalCount(@Param("cri")Criteria cri);

	ArrayList<CommunityVO> selectCommunityList();

	boolean insertBoard(@Param("board")BoardVO board);

	void insertFile(@Param("file")FileVO fileVo);

	void updateView(@Param("boNum")int boNum);
	
	BoardVO selectBoard(@Param("boNum")int boNum);

	ArrayList<FileVO> selectFileList(@Param("boNum")int boNum);


}
