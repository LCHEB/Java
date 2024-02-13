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

# 지역을 추가하는 쿼리
# (서울, 경기, 인천, 강원, 대전/충청, 대구, 부산/울산, 경상, 광주/전라/제주)
insert into region values
('서울'),('경기'),('인천'),('강원'),('대전/충청'),
('대구'),('부산/울산'),('경상'),('광주/전라/제주');

# 영화관을 추가하는 쿼리
# CGV강남, 서울특별시 강남구 역삼동, 좌석수 : 0, 상영관수 : 3, 서울
# CGV영등포, 서울특별시 영등포구 4가, 좌석수 : 0, 상영관수 : 4, 서울
insert into theater values 
(null, 'CGV강남', '서울특별시 강남구 역삼동', 0, 3, '서울'), 
(null, 'CGV영등포', '서울특별시 영등포구 4가', 0, 4, '서울');

# CGV강남에 상영관과 좌석을 추가하는 쿼리
# 1관,10, 2관,12, 3관,6
insert into screen values (null, 1, 10, 1), (null, 2, 12, 1), (null, 3, 6, 1);
# 1관 : A1~A3, B1~B3, C1~C4
insert into seat values 
(null, 'A1', '1'),(null, 'A2', '1'),(null, 'A3', '1'),
(null, 'B1', '1'),(null, 'B2', '1'),(null, 'B3', '1'),
(null, 'C1', '1'),(null, 'C2', '1'),(null, 'C3', '1'),(null, 'C4', '1');
# 2관 : A1~A4, B1~B4, C1~C4
insert into seat values 
(null, 'A1', '2'),(null, 'A2', '2'),(null, 'A3', '2'),(null, 'A4', '2'),
(null, 'B1', '2'),(null, 'B2', '2'),(null, 'B3', '2'),(null, 'B4', '2'),
(null, 'C1', '2'),(null, 'C2', '2'),(null, 'C3', '2'),(null, 'C4', '2');
# 3관 : A1~A2, B1~B2, C1~C2
insert into seat values 
(null, 'A1', '3'),(null, 'A2', '3'),
(null, 'B1', '3'),(null, 'B2', '3'),
(null, 'C1', '3'),(null, 'C2', '3');

# 극장 좌석 업데이트
update theater set th_seat = 30 where th_name = 'CGV강남';
/*
 서브 쿼리를 이용하여 CGV강남에 등록된 좌석수를 계산해서 영화관 전체 좌석수에 업데이트 하는 쿼리
  - 서브 쿼리로 A테이블을 업데이트할 때, 서브 쿼리에 A테이블을 단순 사용하면 업데이트가 되지 않음
  - 이럴 때, A테이블이 아닌 A테이블을 조회한 결과를 이용하면 가능
  - 서브 쿼리가 select count(*) from A일 때, A 대신
  - select count(*) from (select * from A) as 임시이름을 이용해야 한다
*/
UPDATE theater 
SET 
    th_seat = (SELECT 
            COUNT(*)
        FROM
            seat
                JOIN
            screen ON sc_num = se_sc_num
                JOIN
            (SELECT 
                *
            FROM
                theater) AS th ON sc_th_num = th_num
        WHERE
            th_name = 'CGV강남')
WHERE
    th_name = 'CGV강남';

# CGV영등포에 상영관과 좌석을 추가하는 쿼리
# 1관,14, 2관,16, 3관,10, 4관,15
# 1관 : A1~A3, B1~B3, C1~C4, D1~D4
insert into screen values (null, 1, 14, 2);
insert into seat values 
(null, 'A1', '4'),(null, 'A2', '4'),(null, 'A3', '4'),
(null, 'B1', '4'),(null, 'B2', '4'),(null, 'B3', '4'),
(null, 'C1', '4'),(null, 'C2', '4'),(null, 'C3', '4'),(null, 'C4', '4'),
(null, 'D1', '4'),(null, 'D2', '4'),(null, 'D3', '4'),(null, 'D4', '4');

# 2관 : A1~A4, B1~B4, C1~C4, D1~D4
insert into screen values (null, 2, 16, 2);
insert into seat values 
(null, 'A1', '5'),(null, 'A2', '5'),(null, 'A3', '5'),(null, 'A4', '5'),
(null, 'B1', '5'),(null, 'B2', '5'),(null, 'B3', '5'),(null, 'B4', '5'),
(null, 'C1', '5'),(null, 'C2', '5'),(null, 'C3', '5'),(null, 'C4', '5'),
(null, 'D1', '5'),(null, 'D2', '5'),(null, 'D3', '5'),(null, 'D4', '5');

# 3관 : A1~A2, B1~B2, C1~C2, D1~D2, E1~E2
insert into screen values (null, 3, 10, 2);
insert into seat values 
(null, 'A1', '6'),(null, 'A2', '6'),
(null, 'B1', '6'),(null, 'B2', '6'),
(null, 'C1', '6'),(null, 'C2', '6'),
(null, 'D1', '6'),(null, 'D2', '6'),
(null, 'E1', '6'),(null, 'E2', '6');

# 4관 : A1~A5, B1~B5, C1~C5, D1~D5, E1~E5
insert into screen values (null, 4, 25, 2);
insert into seat values 
(null, 'A1', '7'),(null, 'A2', '7'),(null, 'A3', '7'),(null, 'A4', '7'),(null, 'A5', '7'),
(null, 'B1', '7'),(null, 'B2', '7'),(null, 'B3', '7'),(null, 'B4', '7'),(null, 'B5', '7'),
(null, 'C1', '7'),(null, 'C2', '7'),(null, 'C3', '7'),(null, 'C4', '7'),(null, 'C5', '7'),
(null, 'D1', '7'),(null, 'D2', '7'),(null, 'D3', '7'),(null, 'D4', '7'),(null, 'D5', '7'),
(null, 'E1', '7'),(null, 'E2', '7'),(null, 'E3', '7'),(null, 'E4', '7'),(null, 'E5', '7');

# CGV영등포 극장 좌석 업데이트
UPDATE theater 
SET 
    th_seat = (SELECT 
            COUNT(*)
        FROM
            seat
                JOIN
            screen ON sc_num = se_sc_num
                JOIN
            (SELECT 
                *
            FROM
                theater) AS th ON sc_th_num = th_num
        WHERE
            th_name = 'CGV영등포')
WHERE
    th_name = 'CGV영등포';
    
# 상영시간을 추가
# CGV강남 1관 상영시간
# 웡카 - 2월 9일 10:30, 13:00, 16:00, 18:10, 20:30
insert into schedule values(null, '2024-02-09', '10:30', 1, 1, 1),
(null, '2024-02-09', '13:00', 0, 1, 1),
(null, '2024-02-09', '16:00', 0, 1, 1),
(null, '2024-02-09', '18:10', 0, 1, 1),
(null, '2024-02-09', '20:30', 0, 1, 1);
# CGV강남 2관 상영시간
# 웡카 - 2월 9일 11:30, 14:00, 15:00, 19:10, 21:30
insert into schedule values(null, '2024-02-09', '11:30', 1, 2, 1),
(null, '2024-02-09', '14:00', 0, 2, 1),
(null, '2024-02-09', '15:00', 0, 2, 1),
(null, '2024-02-09', '19:10', 0, 2, 1),
(null, '2024-02-09', '21:30', 0, 2, 1);
# CGV강남 3관 상영시간
# 웡카 - 2월 9일 12:20, 14:30, 17:30, 19:50
insert into schedule values(null, '2024-02-09', '12:20', 0, 3, 1),
(null, '2024-02-09', '14:30', 0, 3, 1),
(null, '2024-02-09', '17:30', 0, 3, 1),
(null, '2024-02-09', '19:50', 0, 3, 1);

update schedule set sh_morning = 1 where sh_time < '12:00';

# 기본 요금을 등록
insert into price values(null, '성인', 14000),
(null, '청소년', 10000),
(null, '성인조조', 11200),
(null, '청소년조조', 8000);
# abc123 회원이 웡카를 예매했을 때 쿼리
# CGV강남 1상영관 10:30 영화를 성인 2명, A1, A2를 예매
# ticketing 테이블에 데이터 추가
insert into ticketing values (null, 2, 0, 11200*2, 1,'abc123');
# ticketing_list 테이블에 데이터 추가
insert into ticketing_list values (null, 1, 1),(null, 1, 2);

# 영화관의 전체 좌석수와 전체 상영관 수를 현재 데이터를 기준으로 업데이트하는 쿼리
UPDATE theater 
SET 
    th_seat = (select sum(sc_seat) from screen where sc_th_num = 1),
    th_screen = (select count(sc_name) from screen where sc_th_num = 1)
WHERE
    th_num = 1;
    
# 폴 킹 감독이 웡카 영화 감독으로 참여하는 쿼리
insert into `join` select 1, '감독', (select mp_num FROM
    movie_person
        JOIN
    `character` ON mp_ch_num = ch_num
WHERE
    ch_name = '폴 킹' AND mp_role = '감독'), 1;
