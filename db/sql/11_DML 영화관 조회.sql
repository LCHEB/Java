# 영화 웡카의 영화 정보를 검색하는 쿼리(배우X 감독X 제작국가X 장르X)
select * from movie where mo_title = '웡카';

# 영화 웡카에 출연한 배우 및 감독을 조회 하는 쿼리
select mo_title as 제목, ch_name as 이름, mp_role as 구분 from movie
join 
	`join` on mo_num = jo_mo_num 
join 
	movie_person on jo_mp_num = mp_num
join
	`character` on mp_ch_num = ch_num
where
	mo_title = '웡카';

# CGV강남 1상영관에 등록된 좌석을 조회하는 쿼리
SELECT 
    *
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
WHERE
    sc_name = 1 AND th_name = 'CGV강남';
 
# CGV강남에 등록된 좌석을 조회하는 쿼리
SELECT 
    *
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
WHERE
    th_name = 'CGV강남';
 
 # CGV강남에 등록된 좌석수를 조회하는 쿼리
SELECT 
    COUNT(*)
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
WHERE
    th_name = 'CGV강남';
    
# 영화 웡카를 상영하고 있는 극장을 조회하는 쿼리
SELECT DISTINCT
    mo_title 영화명, th_name 극장명
FROM
    movie
        JOIN
    schedule ON mo_num = sh_mo_num
        JOIN
    screen ON sc_num = sh_sc_num
        JOIN
    theater ON th_num = sc_th_num
WHERE
    mo_title = '웡카';

# CGV강남 1상영관에 웡카 상영 시간을 조회하는 쿼리
SELECT
    mo_title 영화명, th_name 극장명, sc_name 상영관명, sh_time 상영시간
FROM
    movie
        JOIN
    schedule ON mo_num = sh_mo_num
        JOIN
    screen ON sc_num = sh_sc_num
        JOIN
    theater ON th_num = sc_th_num
WHERE
    mo_title = '웡카' and sc_name = 1 and mo_title = '웡카';
# CGV강남 1상영관에 있는 좌석들을 조회하는 쿼리
SELECT 
    sh_date, sh_time, se_name
FROM
    seat
        JOIN
    screen ON sc_num = se_sc_num
        JOIN
    theater ON th_num = sc_th_num
        JOIN
    schedule ON sc_num = sh_sc_num
WHERE
    th_name = 'CGV강남' AND sc_name = 1
        AND sh_date = '2024-02-09'
        AND sh_time = '10:30';
        
# 2월9일 10:30분 CGV강남 1상영관에서 상영하는 웡카를 예매한 좌석을 조회하는 쿼리
SELECT 
    se_name
FROM
    seat
        JOIN
    screen ON sc_num = se_sc_num
        JOIN
    theater ON th_num = sc_th_num
        JOIN
    schedule ON sc_num = sh_sc_num
        JOIN
    ticketing ON sh_num = ti_sh_num
        JOIN
    ticketing_list ON se_num = tl_se_num
WHERE
    th_name = 'CGV강남' AND sc_name = 1
        AND sh_date = '2024-02-09'
        AND sh_time = '10:30';