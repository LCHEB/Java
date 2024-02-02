use test;
# 가입된 회원 전체를 조회
select * from member;

# 아이디가 id2인 회원의 정보를 조회
select * from member where id= "id2";

# 모든 회원의 아이디와 이메일을 조회
select id, email from member;

#24년돈에 가입한 회원을 조회
select * from member where reg_date like "2024-%";

# 이메일이 네이버인 회원을 조회
select * from member where email like "%_@naver.com%";