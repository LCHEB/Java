/*
테이블명만 쓰는 것과 DB명.테이블명을 쓰는 것의 차이
- 테이블명만 쓰는 경우는 내가 작업하려는 DB가 선택됐을 때
- DB명.테이블명은 현재 선탠된 DB와 상관없이 작업할 수 있다
*/
use test;
# 테이블에 등록된 컬럼 순서에 상관 없이 추가할 때 나열한 컬럼 순서대로 값들을 넣어주면 됨
insert into member(id, pw, email, reg_date) values("abc", "def", "abc@naver.com", now());
insert into member(pw, id, reg_date, email) 
	values("pw123", "id21", now(), "ab@naver.com");
# 속성명을 생략한 대신, 테이블에 등록된 컬럼 순서대로 값들을 넣어주어야 함
insert into member
	values("id2", "pw456", "oran@naver.com", now());
# now()를 이용해서 날짜를 문자열에 저장하면 날짜가 문자열로 변환되서 문제가 없음
# 날짜 형태가 아닌 문자열을 datetime에 저장하려 하면 에러가 발생
/*insert into member
	values("id3", "pw9999", now(), "oran@naver.com");*/
# 날짜형태의 문자열을 datetime에 저장하려 하면 변환이 가능하기 때문에 정상 동작
insert into member
	values("id3", "pw9999", now(), "2024-02-01 16:25:00");
    
# 아이디가 id3인 회원의 이메일을 id3@naver.com으로 수정하는 쿼리
update member set email = "id3@naver.com" where id = "id3";
# 아이디가 id2인 회원의 비번을 idabc로, 이메일을 idabc@naver.com으로 수정하는 쿼리
update member set id = "idabc", email = "idabc@naver.com" where id = "id2";

# 아이디가 abc인 회원의 정보를 삭제하는 쿼리
delete from member where id = "abc";

# member 테이블을 조회
select id, pw, email, reg_date from member;
select * from member;

# id가 id2인 회원의 정보를 조회
select * from member where id = "id2";