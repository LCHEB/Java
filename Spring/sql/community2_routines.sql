
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `board_recommend`(
	in _id varchar(13),
    in _bo_num int,
    in _state int
)
begin
	declare _re_num int;
    declare _re_state int;
	# 아이디, 게시글 번호를 이용하여 등록된 추천 번호를 조회해서 변수에 저장
    set _re_num = (select re_num from recommend where re_me_id = _id and re_bo_num = _bo_num);
    # 추천 번호가 null이면 추천 테이블에 추가
    if _re_num is null then
    insert into recommend(re_bo_num, re_me_id, re_state) values(_bo_num, _id, _state);
    # 추천 번호가 null이 아니면
    else
		# 추천 번호에 맞는 추천 상태를 가져옴
        set _re_state = (select re_state from recommend where re_num = _re_num);
        # 추천 상태가 _state와 같으면 취소
        if _re_state = _state then
			update recommend set re_state = 0 
            where re_bo_num = _bo_num and re_me_id = _id;
        # 추천 상태가 _state와 다르면 _state로 수정
        else
			update recommend set re_state = _state 
            where re_bo_num = _bo_num and re_me_id = _id;
        end if;
	end if;
end ;;
DELIMITER ;

