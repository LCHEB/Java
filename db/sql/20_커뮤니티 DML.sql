use community2;

# 회원 상태를 추가하는 쿼리(이용 중, 기간 정지, 영구 정지, 탈퇴)
insert into member_state values('이용중'), ('기간정지'), ('영구정지'), ('탈퇴');
# 아이디 : abc123, 비번 : abc123, 이메일 : abc123@kh.co.kr, 권한 : USER
insert into member(me_id, me_pw, me_email, me_ms_state) values('abc123', 'abc123', 'abc123@kh.co.kr', '이용중');
# 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.co.kr, 권한 : USER
insert into member(me_id, me_pw, me_email, me_ms_state) values('qwe123', 'qwe123', 'qwe123@kh.co.kr', '이용중');
# 아이디 : admin, 비번 : admin, 이메일 : admin@kh.co.kr, 권한 : ADMIN
insert into member(me_id, me_pw, me_email, me_authority, me_ms_state) values('admin', 'admin', 'admin@kh.co.kr', 'ADMIN', '이용중');

# 관리자가 커뮤니티를 등록(공지, 자유, 토론, 공부)
insert into community(co_name) values('공지');
insert into community(co_name) values('자유');
insert into community(co_name) values('토론');
insert into community(co_name) values('공부');

# abc123회원이 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 테스트, 내용 : 테스트 입니다., 첨부파일 : 없음
insert into board(bo_co_num, bo_me_id, bo_title, bo_content) values(2, 'abc123', '테스트', '테스트 입니다.');

insert into board(bo_co_num, bo_me_id, bo_title, bo_content)
select co_num, 'abc123', '테스트', '테스트입니다' from community where co_num = '자유';

# admin 관리자가 공지 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 공지사항, 내용 : 공지사항입니다. 첨부파일 : 공지사항1.jpg
# 첨부파일은 서버업로드 되면 현재 날짜를 기준으로 폴더를 생성해서 업로드 함
# 업로드된 첨부파일은 /2024/02/14/ 파일명으로 저장
insert into board(bo_co_num, bo_me_id, bo_title, bo_content) values(1, 'admin', '공지사항', '공지사항입니다.');
insert into file(fi_bo_num, fi_name, fi_ori_name) values(2, '/2024/02/14/공지사항1.jpg', '공지사항1.jpg');

# 공지 커뮤니티에 등록된 모든 게시글을 조회하는 쿼리
SELECT 
    *
FROM
    community
        JOIN
    board ON bo_co_num = co_num
WHERE
    co_name = '공지';

# 공지 커뮤니티에 등록된 게시글 중 1페이지 해당하는 게시글을 조회하는 쿼리
SELECT 
    *
FROM
    community
        JOIN
    board ON bo_co_num = co_num
WHERE
    co_name = '공지'
order by bo_num desc
limit 0, 10;

# 2번 게시글을 상세 조회했을 때 실행되는 쿼리
# 2번 게시글의 조회수를 증가하는 쿼리 
update board set bo_view = bo_view + 1 where bo_num = 2;
# 2번 게시글 조회하는 쿼리
select * from board where bo_num = 2;

# 게시글 목록에서 abc123 아이디를 클릭했을 때 실행되는 쿼리 
SELECT 
    *
FROM
    board
WHERE
    bo_me_id = 'abc123'
ORDER BY bo_num DESC
LIMIT 0 , 10;

# qwe123회원이 1번 게시글의 추천 버튼을 클릭 했을 때 실행되는 쿼리
# qwe123회원이 1번 게시글에 추천한 기록을 조회
select * from recommend join board on re_bo_num = bo_num where re_me_id = 'abc123' and bo_num = 1;
# 추천한 기록이 없다면 추천을 추가
insert into recommend(re_bo_num, re_me_id, re_state) values(1, 'abc123', 1);
# 추천한 기록이 있다면 추천을 수정
update recommend set re_state = 0 where re_bo_num = 1 and re_me_id = 'abc123';
update recommend set re_state = 1 where re_bo_num = 1 and re_me_id = 'abc123';

# 아이디와 게시글이 주어졌을 때 추천 프로시저
DROP PROCEDURE IF EXISTS BOARD_RECOMMEND;

DELIMITER //
CREATE PROCEDURE BOARD_RECOMMEND(
	IN _ID VARCHAR(13),
    IN _BO_NUM INT,
    IN _STATE INT # 1이면 추천, -1이면 비추천 
)
BEGIN
	DECLARE _RE_NUM INT;
    DECLARE _RE_STATE INT;
    DECLARE _NEW_STATE INT;
    # 1. 아이디, 게시글 번호를 이용하여 등록된 추천 번호를 조회해서 변수에 저장
    SET _RE_NUM = 
		(SELECT RE_NUM FROM RECOMMEND WHERE RE_ME_ID = _ID AND RE_BO_NUM = _BO_NUM);
    # 2-1. 추천 번호가 NULL이면 추천 테이블에 추가 
    IF _RE_NUM IS NULL THEN
		INSERT INTO RECOMMEND(RE_ME_ID, RE_BO_NUM, RE_STATE)
		VALUES(_ID, _BO_NUM, _STATE);
    
    # 2-2. 추천 번호가 NULL이 아니면
    ELSE
		# 2-2-0. 추천 번호에 맞는 추천 상태를 가져옴 
		SET _RE_STATE = (SELECT RE_STATE FROM RECOMMEND WHERE RE_NUM = _RE_NUM);
        /*
        # 2-2-1. 추천 상태가 _STATE와 같으면 취소(0) => 0으로 수정  
        IF _RE_STATE = _STATE THEN
			UPDATE RECOMMEND SET RE_STATE = 0 
            WHERE RE_BO_NUM = _BO_NUM AND RE_ME_ID = _ID;
		
        # 2-2-2. 추천 상태가 _STATE와 다르면 _STATE로 수정 
        ELSE
			UPDATE RECOMMEND SET RE_STATE = _STATE 
            WHERE RE_BO_NUM = _BO_NUM AND RE_ME_ID = _ID;
        END IF;
        */
        # 2-2-1. 추천 상태가 _STATE와 같으면 취소(0) => 0으로 수정  
        IF _RE_STATE = _STATE THEN
			SET _NEW_STATE = 0;
        # 2-2-2. 추천 상태가 _STATE와 다르면 _STATE로 수정 
        ELSE
			SET _NEW_STATE = _STATE;
        END IF;
        UPDATE RECOMMEND SET RE_STATE = _NEW_STATE 
            WHERE RE_BO_NUM = _BO_NUM AND RE_ME_ID = _ID;
	END IF;
END //
DELIMITER ;

CALL BOARD_RECOMMEND('abc123', 1, -1);board