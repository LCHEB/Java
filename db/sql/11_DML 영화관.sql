# 사용자 아이디가 abc123, 비번이 asd123으로 회원가입을 진행
insert into member values('abc123', 'asd123', 'USER');
# 사용자 아이디가 qwe123, 비번이 qweqwe으로 회원가입을 진행
insert into member(me_id, me_pw) values('qwe123', 'qweqwe');
# 관리자 아이디가 admin, 비번이 admin으로 회원 가입을 진행
insert into member values('admin', 'admin', 'ADMIN');
# CGV에서 영화 웡카를 관리자가 등록하려고 한다. 이때 해야하는 쿼리를 순서대로 써보세요.
# 영화 정보(제목, 내용, 개봉일, 상영시간), 감독 , 배우들, 장르, 연령, 제작 국가, 트레일러, 스틸컷

# 1. 모든 국가를 nation 테이블에 추가(한국, 미국, 영국, 일본, 중국)
insert into nation values('한국'),('미국'),('영국'),('일본'),('중국');

# 2. 모든 연령을 age 테이블에 추가(전체관람가, 12세 이상 관람가, 15세 이상 관람가, 청소년 관람불가, 제한관람가)
insert into age values('전체관람가'),('12세 이상 관람가'),('15세 이상 관람가'),('청소년 관람불가'),('제한관람가');

# 3. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스 정보를
# character 테이블에 추가
insert into `character`(ch_name, ch_birthday, ch_detail, ch_na_name) values
('폴 킹', '1978-07-29', "Paul King", '미국'),
('티모시 샬라메', '1995-12-27', "Timothee Chalamet", '미국'),
('칼라 레인', '2009-04-20', "Calah Lane", '미국'),
('올리비아 콜맨', '1974-01-30', "Olivia Colman", '영국'),
('톰 데이비스', '1979-04-27', "Tom Davis", '영국'),
('휴 그랜트', '1960-09-09', "Hugh Grant", '영국'),
('샐리 호킨스', '1976-04-27', "Sally Hawkins", '영국');

# 4. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스 정보를
# movie_person 테이블에 추가(1에서 추가한 정보를 이용)
insert into movie_person (mp_role, mp_pic, mp_ch_num) values
('감독', null, 8),
('배우', null, 9),
('배우', null, 10),
('배우', null, 11),
('배우', null, 12),
('배우', null, 13),
('배우', null, 14);

# 5. 영화 정보를 이용하여 영화를 등록(movie 테이블)
insert into movie(mo_title, mo_date, mo_content, mo_running, mo_ag_name) values
('웡카', '2024-01-31', '세상에서 가장 달콤한 여정 좋은 일은 모두 꿈에서부터 시작된다!', 116, '전체관람가');


# 6. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스 정보를
# join 테이블에 추가(2에서 추가한 정보를 이용), 배역을 모르면 ""로
insert into `join`(jo_casting, jo_mp_num, jo_mo_num) values
("감독", 22, 1),
("윌리 웡카", 23, 1),
("누들", 24, 1),
("스크러빗 부인", 25, 1),
("블리처", 26, 1),
("움파룸파", 27, 1),
("윌리 웡카의 어머니", 28, 1);

# 7. 모든 장르를 genre 테이블에 추가(액션, 범죄, SF, 드라마, 환타지, 코미디, 로맨스, 스릴러, 공포, 멜로)
insert into genre values('액션'),('범죄'),('SF'),('드라마'),('환타지'),('코미디'),
('로맨스'),('스릴러'),('공포'),('멜로');

# 8. 트레일러 정보를 추가. 파일명은 임의로 정해서 추가. 트레일러 3개, 스틸컷 4개
insert into movie_file(mf_filename, mf_type, mf_mo_num) values 
('트레일러1', '영상', 1),
('트레일러2', '영상', 1),
('트레일러3', '영상', 1),
('스틸컷1', '이미지', 1),
('스틸컷2', '이미지', 1),
('스틸컷3', '이미지', 1),
('스틸컷4', '이미지', 1);

# 9. 영화 제작에 영화와 제작 국가 정보를 추가
insert into production_nation (pn_na_name, pn_mo_num) values('미국', 1),('영국', 1);

# 10. 장르 포함에 영화의 장르를 추가
insert into genre_include (gi_mo_num, gi_ge_name) values(1, '환타지'),(1, '드라마');